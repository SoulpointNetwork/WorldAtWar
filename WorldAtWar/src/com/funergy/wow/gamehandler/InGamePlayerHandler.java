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
	public WorldOfWar main;
	public SimpleItemStack item;
	public ArrayList<Player> pList = new ArrayList<Player>();
	
	public boolean isPlaying(Player p){
		if(pList.contains(p)){return true;}
		return false;
	}
	
	public void removePlayer(Player p){
		pList.remove(p);
	}
	
	public void addPlayer(Player p){
		pList.add(p);
	}
	
	public void setIngamePlayerCount(Integer pcount){
		main.setIngameCount(pcount);
	}
	public void giveStarterItems(Player p){
		p.getInventory().setItem(0, itemStack(Material.IRON_PICKAXE, 1, "&6StarterPickaxe", ""));
		p.getInventory().setItem(1, itemStack(Material.IRON_SPADE, 1, "&6StarterSpade", ""));

		
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
