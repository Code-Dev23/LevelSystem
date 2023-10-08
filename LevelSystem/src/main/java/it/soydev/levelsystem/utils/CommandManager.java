package it.soydev.levelsystem.utils;

import it.soydev.levelsystem.Level;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@SuppressWarnings("all")
public abstract class CommandManager implements CommandExecutor {
    String command;
    String permissions;
    boolean useConsole;

    public CommandManager(String command, String permissions, boolean useConsole){
        this.command = command;
        this.permissions = permissions;
        this.useConsole = useConsole;

        Level.getInstance().getCommand(command).setExecutor(this);
    }

    public abstract void execute(CommandSender sender, String[] args);

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!useConsole && !(sender instanceof Player)) {
            Bukkit.getLogger().warning("You can't execute this command from console.");
            return true;
        }

        if(permissions != null && !sender.hasPermission(permissions)) {
            sender.sendMessage(Utils.getMessage("no-permission"));
            return true;
        }

        execute(sender, args);

        return true;
    }
}