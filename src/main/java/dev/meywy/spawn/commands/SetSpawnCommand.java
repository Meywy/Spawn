package dev.meywy.spawn.commands;

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

    String spawnName = ChatColor.GRAY + "[" + ChatColor.GOLD + "Spawn" + ChatColor.GRAY + "] ";

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if (commandSender instanceof Player) {
            Player player = (Player) commandSender;
            Location location = player.getLocation();


            if (player.hasPermission("spawn.set") || player.hasPermission("spawn.*") ) {
                plugin.getConfig().set("spawn", location);
                plugin.saveConfig();
                player.sendMessage(spawnName + ChatColor.GREEN + "A new spawn has been set!");

            } else {
                player.sendMessage(spawnName + ChatColor.RED + "You do not have permissions!");
            }

        } else {
            commandSender.sendMessage(spawnName + ChatColor.RED + "Only players can use this command!");
        }

        return false;
    }
}
