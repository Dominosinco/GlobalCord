package me.dominosinco.commands;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class HubCommand extends Command {
    public HubCommand() {
        super("hub");
    }

    @Override
    public void execute(CommandSender sender, String[] args) {

        ProxiedPlayer p = (ProxiedPlayer) sender;

        p.sendMessage(ChatColor.GREEN + "Connecting to the Hub server");
        ServerInfo hub = ProxyServer.getInstance().getServerInfo("hub");

        p.connect(hub);

    }
}
