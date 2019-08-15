package me.dominosinco;

import me.dominosinco.commands.*;

import me.dominosinco.events.Event1;

import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.api.plugin.PluginDescription;

public class Global extends Plugin {
    private static Global instance;



    public static Global getInstance() {
        return instance;
    }

    private static void setInstance(Global instance) {
        Global.instance = instance;
    }

    public Global() {
        this.getClass();
    }

    @Override
    public void onEnable() {
        
        // Print onLoad

        System.out.println("Global Loaded");

        // Set instance

        setInstance(this);

        // Print Commands

        System.out.println("Loaded Commands: " + getProxy().getPluginManager().getCommands());

        // Register Commands

        getProxy().getPluginManager().registerCommand(this, new GlobalCommand());
        getProxy().getPluginManager().registerCommand(this, new HubCommand());
        getProxy().getPluginManager().registerCommand(this, new WarpCommand());
        getProxy().getPluginManager().registerCommand(this, new testForgeCommand());
        getProxy().getPluginManager().registerCommand(this, new FindCommand());

        // Register Events

        getProxy().getPluginManager().registerListener(this, new Event1());
    }

    @Override
    public void onDisable() {
        System.out.println("Global Unloaded");
    }
}
