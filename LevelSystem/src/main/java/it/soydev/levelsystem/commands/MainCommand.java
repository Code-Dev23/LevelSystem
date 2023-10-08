package it.soydev.levelsystem.commands;

import it.soydev.levelsystem.Level;
import it.soydev.levelsystem.utils.CommandManager;
import it.soydev.levelsystem.utils.Utils;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MainCommand extends CommandManager {
    public MainCommand() {
        super("levelsystem", null, false);
    }
    @Override
    public void execute(CommandSender sender, String[] args) {
        Player player = (Player) sender;
        if(player.isOp()) {
            if(args.length == 0) {
                player.sendMessage(Utils.color("&8&l➜ &fRunning &2Level&aSystem &fcreated by &2SoyDev_&f."));
                player.sendMessage(Utils.color("&8&l➜ &2&lCOMMANDS &7&lLIST:"));
                player.sendMessage(Utils.color("&a&l- &7/adminlevel <set/add/remove> (player) [amount] &8| &fEdit level and xp."));
                player.sendMessage(Utils.color("&a&l- &7/levelsystem reload &8| &fRefresh config.yml file."));
                player.sendMessage(Utils.color("&a&l- &7/level (player) &8| &fShow the level stats."));
                return;
            }
            if(args[0].equalsIgnoreCase("reload")) {
                Level.getInstance().reloadConfig();
                player.sendMessage(Utils.color("&aConfig refreshed with success!"));
                return;
            }
            player.sendMessage(Utils.color("&8&l➜ &fRunning &2Level&aSystem &fcreated by &2SoyDev_&f."));
            player.sendMessage(Utils.color("&8&l➜ &2&lCOMMANDS &7&lLIST:"));
            player.sendMessage(Utils.color("&a&l- &7/adminlevel <set/add/remove> (player) [amount] &8| &fEdit level and xp."));
            player.sendMessage(Utils.color("&a&l- &7/levelsystem reload &8| &fRefresh config.yml file."));
            player.sendMessage(Utils.color("&a&l- &7/level (player) &8| &fShow the level stats."));
            return;
        }
        player.sendMessage(Utils.color("&8&l➜ &fRunning &2Level&aSystem &fcreated by &2SoyDev_&f."));
    }
}