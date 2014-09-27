package com.funergy.wow.events;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import com.funergy.wow.WorldOfWar;
import com.funergy.wow.gamehandler.InGamePlayerHandler;
import com.funergy.wow.gamehandler.LobbyPlayerHandler;

public class JoinEvent implements Listener{
	public WorldOfWar main;
	public InGamePlayerHandler phandler;
	public LobbyPlayerHandler plobbyhandler;

	
	@EventHandler
	public void playerJoinEvent(PlayerJoinEvent e){
		if(main.getGameState().equalsIgnoreCase("LOBBY")){
		  plobbyhandler.setLobbyPlayerCount(Bukkit.getOnlinePlayers().length);
		  plobbyhandler.giveItems(e.getPlayer());
		  plobbyhandler.teleportPlayer(e.getPlayer());
		  
		}else if(main.getGameState().equalsIgnoreCase("INGAME")){
			//add them to the spectator handler
			//teleport them,...
		}
	}

}
