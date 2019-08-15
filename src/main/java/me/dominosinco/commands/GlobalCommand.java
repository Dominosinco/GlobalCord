package me.dominosinco.commands;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class GlobalCommand extends Command {
    public GlobalCommand() {
        super("global",null,"g");
    }



    @Override
    public void execute(CommandSender commandSender, String[] args) {
        ProxiedPlayer p = (ProxiedPlayer) commandSender;


        if (args.length == 0) {
            p.sendMessage("");
            p.sendMessage(ChatColor.GREEN + "Global | The Ultimate BungeeCord Plugin");
            p.sendMessage(ChatColor.GREEN + "Global | Type /global help");
            p.sendMessage("");
            return;
        }
        String global_arg = args[0];

        if (global_arg == null) {
            p.sendMessage(ChatColor.RED + "Incorrect Syntax | Type /global help");
            return;
        }

        if (global_arg.equalsIgnoreCase("help")) {
            p.sendMessage(ChatColor.GREEN + "Global Help");
        }

    }

}
