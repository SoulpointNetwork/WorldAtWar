package com.funergy.wow.worldmanager;

import org.bukkit.Bukkit;

public class WorldManager {
	public static void resetmap(){
		Bukkit.unloadWorld("map", false);
	}

}
