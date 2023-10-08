package it.soydev.levelsystem.data;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
public class PlayerData {

    private final UUID uuid;
    private final int level;
    private final int xp;

    public PlayerData(UUID uuid, int level, int xp) {
        this.uuid = uuid;
        this.level = level;
        this.xp = xp;
    }
}
