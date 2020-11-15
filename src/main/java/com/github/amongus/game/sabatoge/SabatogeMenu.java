package com.github.amongus.game.sabatoge;

import com.github.amongus.game.Game;
import com.github.amongus.player.Imposter;
import me.mattstudios.mfgui.gui.guis.PersistentGui;

public class SabatogeMenu {

    private final Game game;
    private final PersistentGui gui;
    private final Imposter imposter;

    private int mainSabatogeCooldown;
    private int doorSabatogeCooldown;

    public SabatogeMenu(Game game, Imposter imp) {
        this.game = game;
        this.gui = new PersistentGui(5, "Sabatoge Menu");
        this.imposter = imp;
        this.mainSabatogeCooldown = SabatogeType.OXYGEN.getCooldown();
        this.doorSabatogeCooldown = SabatogeType.DOORS.getCooldown();
    }

    public void initDoors() {

    }


}

public enum SabatogeType {

    OXYGEN(30, false), REACTOR_MELTDOWN(30, false),
    COMMUNICATIONS(30, false), LIGHTS(30, false),
    DOORS(10, true);

    private final int cooldown;
    private final boolean canUseOther;

    private SabatogeType(int seconds, boolean canUseOther) {
        this.cooldown = seconds * 20;
        this.canUseOther = canUseOther;
    }

    public int getCooldown() {
        return cooldown;
    }

    public boolean isCanUseOther() {
        return canUseOther;
    }

}
