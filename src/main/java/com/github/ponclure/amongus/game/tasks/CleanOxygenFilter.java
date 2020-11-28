package com.github.ponclure.amongus.game.tasks;

import com.github.ponclure.amongus.game.Game;
import com.github.ponclure.amongus.player.Participant;
import org.bukkit.Location;
import org.bukkit.event.player.PlayerArmorStandManipulateEvent;

public class CleanOxygenFilter extends Task {

    public CleanOxygenFilter(Game game, String name, Location loc, Participant p) {
        super(game, name, loc, p);
    }

    @Override
    public void execute(PlayerArmorStandManipulateEvent e) {

    }
}
