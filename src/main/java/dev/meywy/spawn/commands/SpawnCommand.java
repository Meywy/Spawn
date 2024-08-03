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

    private static final String Name = ChatColor.GRAY + "[" + ChatColor.GOLD + "Spawn" + ChatColor.GRAY + "] ";
    private static final String NoPerms = Name + ChatColor.RED + "You do not have permissions!";

    public static String getName() { return Name; }
    public static String getNoPerms() { return NoPerms; }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {

        if (!(sender instanceof Player p)) {
            sender.sendMessage(ChatColor.RED + "You must be a player to use this command!");
            return true;
        }

        Location l = plugin.getConfig().getLocation("spawn");
        boolean hasPermission = p.hasPermission("spawn.spawn") || p.hasPermission("spawn.*");

        if (!hasPermission) {
            p.sendMessage(NoPerms);
            return true;
        }

        if (l == null) {
            p.sendMessage(Name + ChatColor.RED + "The spawn location is not set!");
            return true;
        }

        p.teleport(l);
        p.sendMessage(Name + ChatColor.GREEN + "You have been teleported to spawn.");
        return true;
    }
}
