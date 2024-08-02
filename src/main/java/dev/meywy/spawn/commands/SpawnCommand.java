package dev.meywy.spawn.commands;

import dev.meywy.spawn.Spawn;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SpawnCommand implements CommandExecutor {

    private final Spawn plugin;

    public SpawnCommand(Spawn plugin) {
        this.plugin = plugin;
    }

    String spawnName = ChatColor.GRAY + "[" + ChatColor.GOLD + "Spawn" + ChatColor.GRAY + "] ";


    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if (commandSender instanceof Player) {
            Player player = (Player) commandSender;
            Location location = plugin.getConfig().getLocation("spawn");

            if (location != null) {
                if (player.hasPermission("spawn.spawn") || player.hasPermission("spawn.*")) {
                    player.teleport(location);
                    player.sendMessage(spawnName + ChatColor.GREEN + "You have been teleported to spawn.");
                } else {
                    player.sendMessage(spawnName + ChatColor.RED + "You do not have permissions!");
                }
            } else {
                player.sendMessage(spawnName + ChatColor.RED + "The spawn location is not set!");
            }
        }


        return false;
    }
}
