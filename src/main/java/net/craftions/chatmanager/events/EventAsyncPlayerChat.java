/*
 * Copyright (c) 2021 Ben Siebert. All rights reserved.
 */
package net.craftions.chatmanager.events;

import net.craftions.chatmanager.ChatManager;
import net.luckperms.api.model.user.User;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class EventAsyncPlayerChat implements Listener {

    @EventHandler
    public void onAsyncChat(AsyncPlayerChatEvent e){
        User lpUser = ChatManager.lp.getPlayerAdapter(Player.class).getUser(e.getPlayer());
        String prefix = ChatManager.lp.getGroupManager().getGroup(lpUser.getPrimaryGroup()).getCachedData().getMetaData().getPrefix();
        String suffix = ChatManager.lp.getGroupManager().getGroup(lpUser.getPrimaryGroup()).getCachedData().getMetaData().getSuffix();
        if(prefix == null){
            prefix = "";
        }
        if(suffix == null){
            suffix = "";
        }
        String msg = e.getMessage();
        msg = msg.replaceAll("%", "%%");
        if(e.getPlayer().hasPermission("chat.color")){
            msg = msg.replace("&", "§");
        }
        e.setFormat(prefix + e.getPlayer().getName() + suffix + " §r" + msg);
    }
}
