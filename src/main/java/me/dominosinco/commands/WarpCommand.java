package me.dominosinco.commands;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class WarpCommand extends Command {
    public WarpCommand() {
        super("warp");
    }

    @Override
    public void execute(CommandSender sender, String[] args) {

        ProxiedPlayer player = (ProxiedPlayer) sender;

        if (args.length == 0) {
            player.sendMessage(ChatColor.RED + "Incorrect Syntax | Please specify a destination.");
            return;
        }
        if (args.length == 1) {
            ServerInfo server = ProxyServer.getInstance().getServerInfo(args[0]);

            if (server == null) {
                player.sendMessage(ChatColor.RED + "Error connecting to server!" + ChatColor.GRAY + "Error Code: invalid_destination");
                return;
            }
            if (server.isRestricted()) {
                player.sendMessage(ChatColor.RED + "Error connecting to server!" + ChatColor.GRAY + "Error Code: server_restricted");
                return;
            }
            player.connect(server);
            player.sendMessage(ChatColor.GREEN + "Warping you to " + args[0]);
            System.out.println("Warping player " + player + " to " + server);
        }
    }
}
