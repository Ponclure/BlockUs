package com.github.ponclure.amongus.game;

import com.github.ponclure.amongus.player.Imposter;
import com.github.ponclure.amongus.player.Participant;
import com.github.ponclure.amongus.utility.GameUtils;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class Game extends ArenaHolder {

    final Map<UUID, Participant> participants;
    final GameSettings settings;
    final List<Consumer<Game>> closeHandlerList;
    //final BossBar bossBar;

    protected Game(Lobby lobby) {
        super(lobby.arena);
        settings = lobby.settingsBuilder.build();
        participants = GameUtils.chooseImpostors(lobby.set, settings.getImpostorCount());
        closeHandlerList = new ArrayList<>();
        //bossBar = Bukkit.createBossBar("") - Conclure will continue this
    }

    @Override
    protected void asyncTick() {

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

    public Set<Imposter> getImposters() {
        return participants.values().stream().filter(p -> p.isImposter()).map(p -> (Imposter) p).collect(Collectors.toSet());
    }

}
