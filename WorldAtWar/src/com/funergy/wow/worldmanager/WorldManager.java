package com.funergy.wow.worldmanager;

import org.bukkit.Bukkit;

public class WorldManager {
	public void resetmap(){
		Bukkit.unloadWorld("map", false);
	}

}
