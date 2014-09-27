package com.funergy.wow;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.WorldCreator;
import org.bukkit.plugin.java.JavaPlugin;

import com.funergy.wow.events.JoinEvent;
import com.funergy.wow.mysql.Signs;
public class WorldOfWar extends JavaPlugin {
	public Signs signs;
	int lobbypcount = 0;
	int ingamecount = 0;
	int spectatecount = 0;
	String gameState;
	
	String mapName ="towers";
	String serverName ="DC1";
	int id = 0;

	String gamePrefix = ChatColor.GRAY+"["+ChatColor.BLUE+"DirtCombat"+ChatColor.GRAY+"]: "+ChatColor.WHITE;
	
	public void onEnable(){
		Bukkit.getServer().createWorld(new WorldCreator("map"));
		Bukkit.getWorld("map").setAutoSave(false);
		
		Bukkit.getPluginManager().registerEvents(new JoinEvent(), this);

	}

	public String getGamePrefix(){return gamePrefix;}
	public String getGameState(){return gameState;}
	public String getMapName(){return mapName;}
	public String getServerName(){return serverName;}

	
	public Integer getLobbyPCount(){return lobbypcount;}
	public Integer getIngameCount(){return ingamecount;}
	public Integer getSpectateCount(){return spectatecount;}
	public Integer getSignID(){return id;}

	public void setIngameCount(Integer i){ingamecount=i;}
	public void setLobbyCount(Integer i){lobbypcount=i; signs.setPlayerc(i);}
	public void setSpectateCount(Integer i){spectatecount=i;}

	
	

}
