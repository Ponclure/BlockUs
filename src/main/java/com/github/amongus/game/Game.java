package com.github.amongus.game;

import com.github.amongus.player.Participant;
import com.github.amongus.utility.GameUtils;
import org.bukkit.Bukkit;
import org.bukkit.boss.BossBar;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.function.Consumer;

public class Game extends ArenaHolder {

    final Map<UUID, Participant> crewmateData;
    final GameSettings settings;
    final List<Consumer<Game>> closeHandlerList;
    //final BossBar bossBar;

    protected Game(Lobby lobby) {
        super(lobby.arena);
        settings = lobby.settingsBuilder.build();
        crewmateData = GameUtils.chooseImpostors(lobby.set,settings.getImpostorCount());
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
        return crewmateData.containsKey(uuid);
    }

    @Override
    void terminate() {
        closeHandlerList.forEach(it -> it.accept(this));
        super.terminate();
    }

    @Override
    void onPlayerQuit(PlayerQuitEvent event) {
        UUID uuid = event.getPlayer().getUniqueId();
        if (crewmateData.containsKey(uuid)) {
            crewmateData.get(uuid).setDisconnected(true);
        }
    }
}