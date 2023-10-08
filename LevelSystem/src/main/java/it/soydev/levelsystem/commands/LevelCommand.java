package it.soydev.levelsystem.commands;

import it.soydev.levelsystem.Level;
import it.soydev.levelsystem.data.PlayerData;
import it.soydev.levelsystem.utils.CommandManager;
import it.soydev.levelsystem.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class LevelCommand extends CommandManager {
    public LevelCommand() {
        super("level", "levelsystem.command.level", false);
    }
    @Override
    public void execute(CommandSender sender, String[] args) {
        Player player = (Player) sender;
        if(args.length == 0) {
            PlayerData data = Level.getPlayerDataManagers().getPlayerLevel(player.getUniqueId());
            player.sendMessage(Utils.color("&2&lYOUR LEVEL STATISTICS"));
            player.sendMessage(Utils.color("&f"));
            player.sendMessage(Utils.color("&7Level: " + data.getLevel()));
            player.sendMessage(Utils.color("&7XP: " + data.getXp()));
            return;
        }
        Player target = Bukkit.getPlayer(args[0]);
        if(target == null) {
            player.sendMessage(Utils.color("&cPlayer not found."));
            return;
        }
        PlayerData data = Level.getPlayerDataManagers().getPlayerLevel(target.getUniqueId());
        player.sendMessage(Utils.color("&2&l%player% LEVEL STATISTICS").replace("%player%", target.getName()));
        player.sendMessage(Utils.color("&f"));
        player.sendMessage(Utils.color("&7Level: " + data.getLevel()));
        player.sendMessage(Utils.color("&7XP: " + data.getXp()));
    }
}