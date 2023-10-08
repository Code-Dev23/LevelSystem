package it.soydev.levelsystem;

import it.soydev.levelsystem.commands.LevelCommand;
import it.soydev.levelsystem.commands.MainCommand;
import it.soydev.levelsystem.managers.PlayerDataManagers;
import lombok.Getter;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class Level extends JavaPlugin {

    @Getter private static Level instance;
    @Getter private static PlayerDataManagers playerDataManagers;

    @Override
    public void onEnable() {
        instance = this;
        saveDefaultConfig();
        playerDataManagers = new PlayerDataManagers();

        loadCommands();
        loadListeners();
    }

    @Override
    public void onDisable() {

    }

    private void loadCommands() {
        new MainCommand();
        new LevelCommand();
    }

    private void loadListeners() {
        PluginManager pm = getServer().getPluginManager();

    }
}