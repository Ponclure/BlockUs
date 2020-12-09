package com.github.ponclure.blockus.utility;

import com.github.ponclure.blockus.game.Game;
import com.github.ponclure.blockus.player.Imposter;
import com.github.ponclure.blockus.player.Participant;
import com.github.ponclure.blockus.throwable.IllegalInstantiation;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

public final class GameUtils {

    private GameUtils() {
        IllegalInstantiation.deploy(GameUtils.class);
    }

    // CONCLURE FIX THIS AHHHHHH
    public static Map<UUID, Participant> chooseImpostors(Game game, Set<UUID> pool,
                                                         int impostorAmount) throws IllegalArgumentException {
        if (impostorAmount > pool.size()) {
            throw new IllegalArgumentException("Imposter amount cannot be higher than the pool size");
        }
        if (impostorAmount < 0) {
            throw new IllegalArgumentException("Imposter amount cannot be negative");
        }
        Map<UUID, Participant> map = new HashMap<>();
        if (impostorAmount == pool.size()) {
            for (UUID uuid : pool) {
                map.put(uuid, game.getParticipants().get(uuid));
            }
            return map;
        }
        UUID[] array = pool.toArray(new UUID[0]);
        int h = 0;
        for (int i = 0; i < array.length; i++) {
            Participant participant;
            if (h != impostorAmount) {
                participant = game.getParticipants().get(array[i]);
                h++;
            } else {
                participant = game.getParticipants().get(array[i]);
            }
            map.put(array[i], participant);
        }
        return map;
    }

}
