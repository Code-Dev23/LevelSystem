package it.soydev.levelsystem.managers;

import it.soydev.levelsystem.Level;
import it.soydev.levelsystem.data.PlayerData;
import lombok.Getter;

import java.util.Collection;
import java.util.HashSet;
import java.util.UUID;

public class PlayerDataManagers {
    @Getter
    public final Collection<PlayerData> players = new HashSet<>();

    public PlayerData getPlayerLevel(UUID uuid) {
        synchronized (players) {
            PlayerData playerLevel = players.stream().filter(x -> x.getUuid().equals(uuid)).findFirst().orElse(null);

            if (playerLevel == null) {
                players.add(new PlayerData(uuid, 0, 0));
                return getPlayerLevel(uuid);
            }

            return playerLevel;
        }
    }

    public void updatePlayerLevel(PlayerData playerLevel) {
        if (playerLevel == null) return;
        synchronized (players) {
            players.remove(getPlayerLevel(playerLevel.getUuid()));
            players.add(playerLevel);
        }
    }

    public void saveToDatabase() {
        getPlayers().forEach(data -> {
            UUID uuid = data.getUuid();
            int level = data.getLevel();
            int xp = data.getXp();

            // database code...
        });
    }

    public void restoreData() {

    }
}