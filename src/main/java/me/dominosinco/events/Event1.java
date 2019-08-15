package me.dominosinco.events;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.PostLoginEvent;
import net.md_5.bungee.api.plugin.Listener;

public class Event1 implements Listener {

    public void onPostLogin(PostLoginEvent e) {
        ProxiedPlayer p = e.getPlayer();
        ProxyServer proxy = ProxyServer.getInstance();

        if (p.getName() == "Dominosinco10") {

            proxy.broadcast(ChatColor.BLUE + "The owner has joined the network!");
            return;
        }

        p.sendMessage(ChatColor.GREEN + "Welcome to KitNetwork!");



    }

}
