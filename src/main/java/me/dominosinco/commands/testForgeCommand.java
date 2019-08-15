package me.dominosinco.commands;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class testForgeCommand extends Command {
    public testForgeCommand() {
        super("testforge","global.command.testforge","forgetest");
    }

    @Override
    public void execute(CommandSender sender, String[] args) {

        ProxiedPlayer player = (ProxiedPlayer) sender;

        if (args.length == 0) {
            player.sendMessage(ChatColor.RED + "You must specify a player to test!");
            return;
        }
        ProxiedPlayer target = ProxyServer.getInstance().getPlayer(args[0]);

        if (args.length == 1) {
            if (target == null) {
                player.sendMessage(ChatColor.RED + "That player is not valid!");
                return;
            }

            if (target.isForgeUser()) {
                player.sendMessage(ChatColor.GREEN + "Is Using Forge Client" + ChatColor.DARK_GRAY + ":" + ChatColor.GREEN+ " YES");
                return;
            }
            player.sendMessage(ChatColor.GREEN + "Is Using Forge Client" + ChatColor.DARK_GRAY + ":" + ChatColor.RED + " NO");
        }
    }
}
