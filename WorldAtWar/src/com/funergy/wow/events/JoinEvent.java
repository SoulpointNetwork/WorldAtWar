package com.funergy.wow.events;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import com.funergy.wow.WorldOfWar;
import com.funergy.wow.gamehandler.LobbyPlayerHandler;

public class JoinEvent implements Listener{
	public static WorldOfWar main = WorldOfWar.instance;

	
	@EventHandler
	public void playerJoinEvent(PlayerJoinEvent e){
		if(main.getGameState().equalsIgnoreCase("LOBBY")){
		  LobbyPlayerHandler.setLobbyPlayerCount(Bukkit.getOnlinePlayers().length);
		  LobbyPlayerHandler.giveItems(e.getPlayer());
		  LobbyPlayerHandler.teleportPlayer(e.getPlayer());
		  
		}else if(main.getGameState().equalsIgnoreCase("INGAME")){
			//add them to the spectator handler
			//teleport them,...
		}
	}

}
