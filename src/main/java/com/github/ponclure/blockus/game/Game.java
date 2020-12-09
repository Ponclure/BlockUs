package com.github.ponclure.blockus.game;

import com.github.ponclure.blockus.BlockUsPlugin;
import com.github.ponclure.blockus.arena.components.Room;
import com.github.ponclure.blockus.player.Crewmate;
import com.github.ponclure.blockus.player.Imposter;
import com.github.ponclure.blockus.player.Participant;
import com.github.ponclure.blockus.utility.GameUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class Game extends ArenaHolder {

    private final GameSettings settings;
    private final Map<UUID, Participant> participants;
    private final List<Consumer<Game>> closeHandlerList;
    private final UUID uuid;
    private final int taskTotal;
    private final BossBar bossBar;
    private final Lobby lobby;
    private Map<UUID, Map.Entry<Room, Integer>> playerRooms;

    protected Game(Lobby lobby, UUID uuid) {
        super(lobby.arena);
        this.settings = lobby.settingsBuilder.build();
        this.participants = GameUtils.chooseImpostors(this, lobby.set, settings.getImpostorCount());
        this.closeHandlerList = new ArrayList<>();
        this.playerRooms = new HashMap<>();
        this.uuid = uuid == null ? UUID.randomUUID() : uuid;
        this.taskTotal = getTaskTotal();
        this.bossBar = Bukkit.createBossBar(ChatColor.GREEN + "Tasks Progress", BarColor.BLUE, BarStyle.SOLID);
        this.lobby = lobby;
        BlockUsPlugin.getBlockUs().getGames().put(uuid, this);
    }

    public int getTaskTotal() {
        int total = 0;
        for (Participant p : participants.values()) {
            if (!p.isImposter()) {
                total += ((Crewmate)p).getTasks().size();
            }
        }
        return total;
    }

    @Override
    protected void asyncTick() {
        int count = 0;
        for (Participant p : participants.values()) {
            if (!p.isImposter()) {
                count += ((Crewmate)p).getTodo().size();
            }
        }
        bossBar.setProgress(count/taskTotal);
    }

    public void onClose(Consumer<Game> action) {
        closeHandlerList.add(action);
    }

    @Override
    public boolean contains(UUID uuid) {
        return participants.containsKey(uuid);
    }

    public Map<UUID, Participant> getParticipants() {
        return participants;
    }

    @Override
    void terminate() {
        closeHandlerList.forEach(it -> it.accept(this));
        super.terminate();
    }

    @Override
    void onPlayerQuit(PlayerQuitEvent event) {
        UUID uuid = event.getPlayer().getUniqueId();
        if (participants.containsKey(uuid)) {
            participants.get(uuid).setDisconnected(true);
        }
    }

    public GameSettings getSettings() {
        return settings;
    }

    public HashSet<Imposter> getImposters() {
        return new HashSet<>(participants.values().stream().filter(p -> p.isImposter()).map(p -> (Imposter) p).collect(Collectors.toSet()));
    }

    public Map<UUID, Map.Entry<Room, Integer>> getPlayerRooms() {
        return playerRooms;
    }

    public void setPlayerRooms(Map<UUID, Map.Entry<Room, Integer>> rooms) {
        playerRooms = rooms;
    }

    public Lobby getLobby() { return lobby; }

}
