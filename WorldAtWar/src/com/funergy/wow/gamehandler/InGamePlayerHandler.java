package com.funergy.wow.gamehandler;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.funergy.wow.WorldOfWar;
import com.funergy.wow.utils.SimpleItemStack;

public class InGamePlayerHandler {
	public static WorldOfWar plugin = WorldOfWar.instance;

	public static SimpleItemStack item;
	public static ArrayList<Player> pList = new ArrayList<Player>();
	
	public static boolean isPlaying(Player p){
		if(pList.contains(p)){return true;}
		return false;
	}
	
	public static void removePlayer(Player p){
		pList.remove(p);
	}
	
	public static void addPlayer(Player p){
		pList.add(p);
	}
	
	public static void setIngamePlayerCount(Integer pcount){
		plugin.setIngameCount(pcount);
	}
	public static void giveStarterItems(Player p){
		p.getInventory().setItem(0, itemStack(Material.IRON_PICKAXE, 1, "&6StarterPickaxe", ""));
		p.getInventory().setItem(1, itemStack(Material.IRON_SPADE, 1, "&6StarterSpade", ""));

		
	}
	public static ItemStack itemStack(Material mat, Integer amount, String displayname, String Lore){
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
