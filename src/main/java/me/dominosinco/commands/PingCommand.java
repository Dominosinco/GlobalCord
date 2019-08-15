package me.dominosinco.commands;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class PingCommand extends Command {
    public PingCommand() {
        super("ping");
    }

    @Override
    public void execute(CommandSender commandSender, String[] args) {

        ProxiedPlayer player = (ProxiedPlayer) commandSender;

        if (args.length == 0) {
            player.sendMessage(ChatColor.GREEN + "Your ping: " + player.getPing() + " ms");
            player.sendMessage(ChatColor.YELLOW + "Type \"/ping <player>\" to see a players ping");
            return;
        }
        ProxiedPlayer target = ProxyServer.getInstance().getPlayer(args[0]);

        if (target == null) {
            player.sendMessage(ChatColor.RED + args[0] + " is an invalid player! Usage: /ping <player>");
            return;
        }
        player.sendMessage(ChatColor.GREEN + args[0] + "'s ping: " + target.getPing() + " ms");
    }
}
