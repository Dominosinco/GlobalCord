package me.dominosinco.commands;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class FindCommand extends Command {
    public FindCommand() {
        super("findplayer","global.command.find");
    }

    @Override
    public void execute(CommandSender commandSender, String[] args) {

        ProxiedPlayer player = (ProxiedPlayer) commandSender;

        if (args.length == 0) {
            player.sendMessage(ChatColor.RED + "You must supply a player!");
            return;
        }
        ProxiedPlayer target = ProxyServer.getInstance().getPlayer(args[0]);

        if (target == null) {
            player.sendMessage(ChatColor.RED + args[0] + " is an invalid player!");
            return;
        }
        player.sendMessage(ChatColor.GREEN + args[0] + " is currently connected to: " + target.getServer().getInfo().getName());

    }
}
