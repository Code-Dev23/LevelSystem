package it.soydev.levelsystem.utils;

import it.soydev.levelsystem.Level;
import lombok.experimental.UtilityClass;
import org.bukkit.ChatColor;

@UtilityClass
public class Utils {
    public String color(String text) {
        return ChatColor.translateAlternateColorCodes('&', text);
    }
    public String getMessage(String path) {
        return color(Level.getInstance().getConfig().getString("messages." + path));
    }
}
