package com.waaz.gui;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.material.MaterialData;

public class Gui {
	
	@SuppressWarnings("deprecation")
	public void Stack(String Display, int ID, int DATA, int STACK, List<String> lore, int loc, Inventory inven)
	{
		ItemStack item = new MaterialData(ID, (byte) DATA).toItemStack(STACK);
		ItemMeta itm = item.getItemMeta();
		itm.setDisplayName(Display);
		itm.setLore(lore);
		item.setItemMeta(itm);
		inven.setItem(loc, item);
	}
	
	public void openChat(Player p) throws IOException
	{
		UUID uniq = p.getUniqueId();
		Inventory inven = Bukkit.createInventory(null, 9, ChatColor.AQUA + "채팅방 선택");
		int stand = com.waaz.main.Main.readPF(uniq);
		if(stand == 0) {
			Stack(ChatColor.GRAY + "채팅방 1 (비활성화)", 95, 15, 1, Arrays.asList(ChatColor.GREEN + "클릭해 활성화!"), 1, inven);
			Stack(ChatColor.GRAY + "채팅방 2 (비활성화)", 95, 15, 1, Arrays.asList(ChatColor.GREEN + "클릭해 활성화!"), 3, inven);
			Stack(ChatColor.GRAY + "채팅방 3 (비활성화)", 95, 15, 1, Arrays.asList(ChatColor.GREEN + "클릭해 활성화!"), 5, inven);
			Stack(ChatColor.GRAY + "채팅방 4 (비활성화)", 95, 15, 1, Arrays.asList(ChatColor.GREEN + "클릭해 활성화!"), 7, inven);
		}
		else if(stand == 1)
		{
			Stack(ChatColor.GREEN + "채팅방 1 (활성화!)", 95, 5, 1, Arrays.asList(ChatColor.GREEN + "활성화됨!"), 1, inven);
			Stack(ChatColor.GRAY + "채팅방 2 (비활성화)", 95, 15, 1, Arrays.asList(ChatColor.GREEN + "클릭해 활성화!"), 3, inven);
			Stack(ChatColor.GRAY + "채팅방 3 (비활성화)", 95, 15, 1, Arrays.asList(ChatColor.GREEN + "클릭해 활성화!"), 5, inven);
			Stack(ChatColor.GRAY + "채팅방 4 (비활성화)", 95, 15, 1, Arrays.asList(ChatColor.GREEN + "클릭해 활성화!"), 7, inven);
		}
		else if(stand == 2)
		{
			Stack(ChatColor.GREEN + "채팅방 2 (활성화!)", 95, 5, 1, Arrays.asList(ChatColor.GREEN + "활성화됨!"), 3, inven);
			Stack(ChatColor.GRAY + "채팅방 1 (비활성화)", 95, 15, 1, Arrays.asList(ChatColor.GREEN + "클릭해 활성화!"), 1, inven);
			Stack(ChatColor.GRAY + "채팅방 3 (비활성화)", 95, 15, 1, Arrays.asList(ChatColor.GREEN + "클릭해 활성화!"), 5, inven);
			Stack(ChatColor.GRAY + "채팅방 4 (비활성화)", 95, 15, 1, Arrays.asList(ChatColor.GREEN + "클릭해 활성화!"), 7, inven);
		}
		else if(stand == 3)
		{
			Stack(ChatColor.GREEN + "채팅방 3 (활성화!)", 95, 5, 1, Arrays.asList(ChatColor.GREEN + "활성화됨!"), 5, inven);
			Stack(ChatColor.GRAY + "채팅방 1 (비활성화)", 95, 15, 1, Arrays.asList(ChatColor.GREEN + "클릭해 활성화!"), 1, inven);
			Stack(ChatColor.GRAY + "채팅방 2 (비활성화)", 95, 15, 1, Arrays.asList(ChatColor.GREEN + "클릭해 활성화!"), 3, inven);
			Stack(ChatColor.GRAY + "채팅방 4 (비활성화)", 95, 15, 1, Arrays.asList(ChatColor.GREEN + "클릭해 활성화!"), 7, inven);
		}
		else if(stand == 4)
		{
			Stack(ChatColor.GREEN + "채팅방 4 (활성화!)", 95, 5, 1, Arrays.asList(ChatColor.GREEN + "활성화됨!"), 7, inven);
			Stack(ChatColor.GRAY + "채팅방 1 (비활성화)", 95, 15, 1, Arrays.asList(ChatColor.GREEN + "클릭해 활성화!"), 1, inven);
			Stack(ChatColor.GRAY + "채팅방 3 (비활성화)", 95, 15, 1, Arrays.asList(ChatColor.GREEN + "클릭해 활성화!"), 5, inven);
			Stack(ChatColor.GRAY + "채팅방 2 (비활성화)", 95, 15, 1, Arrays.asList(ChatColor.GREEN + "클릭해 활성화!"), 3, inven);
		}else {
			return;
		}
		p.openInventory(inven);
	}

}
