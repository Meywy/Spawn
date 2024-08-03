package dev.meywy.spawn.commands;

import dev.meywy.spawn.commands.SpawnCommand;
import dev.meywy.spawn.Spawn;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;



public class SetSpawnCommand implements CommandExecutor {

    private final Spawn plugin;

    public SetSpawnCommand(Spawn plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {

        if (!(sender instanceof Player p)) {
            sender.sendMessage(ChatColor.RED + "You must be a player to use this command!");
            return true;
        }

        boolean hasPermission = p.hasPermission("spawn.spawn") || p.hasPermission("spawn.*");

        if (!hasPermission) {
            p.sendMessage(SpawnCommand.getNoPerms());
            return true;
        }

        Location l = p.getLocation();
        plugin.getConfig().set("spawn", l);
        plugin.saveConfig();
        p.sendMessage(SpawnCommand.getName() + ChatColor.GREEN + "A new spawn has been set!");
        return true;
    }
}

