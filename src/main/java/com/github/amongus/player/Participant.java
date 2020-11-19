package com.github.amongus.player;

import com.github.amongus.game.Game;
import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import com.mojang.util.UUIDTypeAdapter;
import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_16_R2.entity.CraftPlayer;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.UUID;

public class Participant {

    private final Game game;

    private final UUID uuid;
    private final String nick;
    private final PlayerColor color;

    private boolean isDead;
    private boolean isDisconnected;

    public Participant(Game game, UUID player, PlayerColor color) {
        this.game = game;
        this.uuid = player;
        this.nick = Bukkit.getPlayer(uuid).getName();
        this.color = color;
        // GameProfile playerProfile = ((CraftPlayer) Bukkit.getPlayer(player)).getHandle().getProfile();

    }

    public boolean isDead() {
        return isDead;
    }

    public void setDead(boolean dead) {
        isDead = dead;
    }

    public UUID getUuid() {
        return uuid;
    }

    public String getNick() {
        return nick;
    }

    public boolean isDisconnected() {
        return isDisconnected;
    }

    public void setDisconnected(boolean disconnected) {
        isDisconnected = disconnected;
    }

    public boolean isImposter() {
        return (this instanceof Imposter);
    }

    public PlayerColor getColor() {
        return color;
    }

    public enum PlayerColor {
        RED, BLUE, GREEN, YELLOW, ORANGE, BLACK, WHITE, PURPLE, CYAN, BROWN, LIME;
    }

    public static boolean setSkin(GameProfile profile, UUID uuid) {
        try {
            HttpsURLConnection connection = (HttpsURLConnection) new URL(String.format("https://sessionserver.mojang.com/session/minecraft/profile/%s?unsigned=false", UUIDTypeAdapter.fromUUID(uuid))).openConnection();
            if (connection.getResponseCode() == HttpsURLConnection.HTTP_OK) {
                String reply = new BufferedReader(new InputStreamReader(connection.getInputStream())).readLine();
                String skin = reply.split("\"value\":\"")[1].split("\"")[0];
                String signature = reply.split("\"signature\":\"")[1].split("\"")[0];
                profile.getProperties().put("textures", new Property("textures", skin, signature));
                return true;
            } else {
                System.out.println("Connection could not be opened (Response code " + connection.getResponseCode() + ", " + connection.getResponseMessage() + ")");
                return false;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

}
