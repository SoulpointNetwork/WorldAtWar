package com.funergy.wow.timers;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

import com.funergy.wow.WorldOfWar;

public class LobbyTimer {
	public WorldOfWar main;
	
	public LobbyTimer(){
		Bukkit.broadcastMessage(main.getGamePrefix()+"Lobby timer starting.");
		new BukkitRunnable(){
			int i = 40;
			@Override
			public void run() {
				if(main.getGameState().equalsIgnoreCase("LOBBY")){
				if(i == 1){
					if(main.getLobbyPCount() == 8){
						//start game
						this.cancel();
						return;
					}else{
						Bukkit.broadcastMessage(main.getGamePrefix()+"Not enough players online restarting timer!");
						i = 30;
					}
				}
				for(Player p : Bukkit.getOnlinePlayers()){
					p.setLevel(i);
				}
				i-=1;
			}else{
				this.cancel();
				return;
			}
			}
			
		}.runTaskTimer((Plugin) this, 0, 20);
	}

}
