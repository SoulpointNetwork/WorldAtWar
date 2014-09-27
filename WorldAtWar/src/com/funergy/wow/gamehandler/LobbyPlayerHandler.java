package com.funergy.wow.gamehandler;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.funergy.wow.WorldOfWar;

public class LobbyPlayerHandler {
	public WorldOfWar main;	
	
	public void setLobbyPlayerCount(Integer pcount){
		main.setLobbyCount(pcount);
	}
	public void giveItems(Player p){
		p.getInventory().setItem(0, itemStack(Material.WATCH, 1, "&6Choose your team", "Right click to open the GUI"));
	}
	public void teleportPlayer(Player p){
		//teleport the player to the lobby
	}
	
	public ItemStack itemStack(Material mat, Integer amount, String displayname, String Lore){
		ItemStack im = new ItemStack(mat,amount);
		ItemMeta m = im.getItemMeta();
		if(displayname !=null){
		m.setDisplayName(ChatColor.translateAlternateColorCodes('&',displayname));
		}
		if(Lore != null){
		ArrayList<String> lore = new ArrayList<String>();
		m.setLore(lore);
		}
		im.setItemMeta(m);
		
		return im;
	}



}
