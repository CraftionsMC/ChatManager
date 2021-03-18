package net.craftions.chatmanager;

import net.craftions.chatmanager.events.EventAsyncPlayerChat;
import net.luckperms.api.LuckPerms;
import org.bukkit.Bukkit;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

public final class ChatManager extends JavaPlugin {

    public static LuckPerms lp;

    @Override
    public void onEnable() {
        initLuckPerms();
        Bukkit.getPluginManager().registerEvents(new EventAsyncPlayerChat(), this);
    }

    public void initLuckPerms(){
        RegisteredServiceProvider<LuckPerms> provider = Bukkit.getServicesManager().getRegistration(LuckPerms.class);
        if(provider != null){
            provider.getProvider();
            lp = provider.getProvider();
        }
    }
}
