package com.waaz.event;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

import com.waaz.gui.Gui;
import com.waaz.main.Main;


public class EventListener implements Listener{
	Gui gui = new Gui();
	private Plugin plugin = Main.getPlugin(Main.class);
	
	@EventHandler
	public void onJoin(PlayerJoinEvent event) 
	{
		Player player = event.getPlayer();
		File chatroom = new File("plugins/ChatRoom/" + String.valueOf(player.getUniqueId()) + ".txt");
		if(!(chatroom.exists())) {
		try {
			chatroom.createNewFile();
			BufferedWriter br = new BufferedWriter(new FileWriter(chatroom));
			br.append("0");
			br.flush();
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		if(plugin.getConfig().getBoolean("IfFirstJoinShow") == true) {
			new BukkitRunnable() {

				@Override
				public void run() {
					try {
						gui.openChat(player);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
			}.runTaskLaterAsynchronously((Plugin) this, 5);
		}
						
		}
	}
	
	@EventHandler
	public void onClick(InventoryClickEvent event)
	{
		Player player = (Player) event.getWhoClicked();
		Inventory inven = event.getInventory();
		ItemStack item = event.getCurrentItem();
		UUID uniq = player.getUniqueId();
		
		if(ChatColor.stripColor(inven.getName()).equalsIgnoreCase("채팅방 선택")) {
			if(item == null || item.getType() == Material.AIR || !(item.hasItemMeta()))
			{
				event.setCancelled(false);
			}
			else {
				event.setCancelled(true);
				switch(ChatColor.stripColor(item.getItemMeta().getDisplayName()))
				{
					case "채팅방 1 (비활성화)":
						com.waaz.main.Main.writePF(uniq, 1);
						for(int i = 0; i < 50; i++) {
						player.sendMessage("\n");
						}
						player.sendMessage(ChatColor.WHITE + "[ " + ChatColor.AQUA + "!" + ChatColor.WHITE + " ]" + ChatColor.GRAY + " 채팅방 " + ChatColor.AQUA + " 1 " + ChatColor.GRAY + "으로 옮기셨습니다! 건전한 채팅 부탁드려요!");
						player.closeInventory();
						break;
					
					case "채팅방 1 (활성화!)":
						com.waaz.main.Main.writePF(uniq, 0);
						player.sendMessage(ChatColor.WHITE + "[ " + ChatColor.AQUA + "!" + ChatColor.WHITE + " ]" + ChatColor.GRAY + " 채팅방 1에서 나왔습니다!");
						player.closeInventory();
						break;
						
					case "채팅방 2 (비활성화)":
						if(plugin.getConfig().getInt("ChatRoom") > 1)
						{
							com.waaz.main.Main.writePF(uniq, 2);
							for(int i = 0; i < 50; i++) {
							player.sendMessage("\n");
							}
							player.sendMessage(ChatColor.WHITE + "[ " + ChatColor.AQUA + "!" + ChatColor.WHITE + " ]" + ChatColor.GRAY + " 채팅방 " + ChatColor.AQUA + " 2 " + ChatColor.GRAY + "으로 옮기셨습니다! 건전한 채팅 부탁드려요!");
						}else {
							player.sendMessage(ChatColor.WHITE + "[ " + ChatColor.AQUA + "!" + ChatColor.WHITE + " ]" + ChatColor.GRAY + " 관리자가 채팅방 1(또는 2) 만 사용할 수 있도록 했습니다!");
						}
						player.closeInventory();
						break;
						
					case "채팅방 2 (활성화!)":
						com.waaz.main.Main.writePF(uniq, 0);
						player.sendMessage(ChatColor.WHITE + "[ " + ChatColor.AQUA + "!" + ChatColor.WHITE + " ]" + ChatColor.GRAY + " 채팅방 2에서 나왔습니다!");
						player.closeInventory();
						break;
					
					case "채팅방 3 (비활성화)":
						if(plugin.getConfig().getInt("ChatRoom") > 2)
						{
							com.waaz.main.Main.writePF(uniq, 3);
							for(int i = 0; i < 50; i++) {
							player.sendMessage("\n");
							}
							player.sendMessage(ChatColor.WHITE + "[ " + ChatColor.AQUA + "!" + ChatColor.WHITE + " ]" + ChatColor.GRAY + " 채팅방 " + ChatColor.AQUA + " 3 " + ChatColor.GRAY + "으로 옮기셨습니다! 건전한 채팅 부탁드려요!");
						}else {
							player.sendMessage(ChatColor.WHITE + "[ " + ChatColor.AQUA + "!" + ChatColor.WHITE + " ]" + ChatColor.GRAY + " 관리자가 채팅방 1(또는 2,3) 만 사용할 수 있도록 했습니다!");
						}
						player.closeInventory();
						break;
						
					case "채팅방 3 (활성화!)":
						com.waaz.main.Main.writePF(uniq, 0);
						player.sendMessage(ChatColor.WHITE + "[ " + ChatColor.AQUA + "!" + ChatColor.WHITE + " ]" + ChatColor.GRAY + " 채팅방 3에서 나왔습니다!");
						player.closeInventory();
						break;
						
					case "채팅방 4 (비활성화)":
						if(plugin.getConfig().getInt("ChatRoom") == 4)
						{
							com.waaz.main.Main.writePF(uniq, 4);
							for(int i = 0; i < 50; i++) {
							player.sendMessage("\n");
							}
							player.sendMessage(ChatColor.WHITE + "[ " + ChatColor.AQUA + "!" + ChatColor.WHITE + " ]" + ChatColor.GRAY + " 채팅방 " + ChatColor.AQUA + " 4 " + ChatColor.GRAY + "으로 옮기셨습니다! 건전한 채팅 부탁드려요!");
						}else {
							player.sendMessage(ChatColor.WHITE + "[ " + ChatColor.AQUA + "!" + ChatColor.WHITE + " ]" + ChatColor.GRAY + " 관리자가 채팅방 1(또는 2,3,4) 만 사용할 수 있도록 했습니다!");
						}
						player.closeInventory();
						break;
						
					case "채팅방 4 (활성화!)":
						com.waaz.main.Main.writePF(uniq, 0);
						player.sendMessage(ChatColor.WHITE + "[ " + ChatColor.AQUA + "!" + ChatColor.WHITE + " ]" + ChatColor.GRAY + " 채팅방 4에서 나왔습니다!");
						player.closeInventory();
						break;
					default:
						return;
					
				}
				
			}
		}
	}
	
	@EventHandler
	public void onChat(AsyncPlayerChatEvent e) 
	{
		Player chatter = e.getPlayer();
		String opr = chatter.getDisplayName();
		String msg = e.getMessage();
		for(Player p : Bukkit.getOnlinePlayers())
		{
			try {
				int ci = com.waaz.main.Main.readPF(chatter.getUniqueId());
				int pi = com.waaz.main.Main.readPF(p.getUniqueId());
				if(ci != 0) {
					if(ci == pi)
					{
						String npr = ChatColor.WHITE + "[ " + ChatColor.AQUA + "채팅방 " + String.valueOf(ci)  + ChatColor.WHITE +" ] " + opr + ChatColor.WHITE + " : " + msg;
						e.setFormat(npr);
					}else {
						if(p.hasPermission("cr.hear"))
						{
							String npr = ChatColor.WHITE + "[ " + ChatColor.LIGHT_PURPLE + "채팅방 " + String.valueOf(ci) + ChatColor.WHITE +" ] " + opr + ChatColor.WHITE + " : " + msg;
							e.setFormat(npr);
						}else {
						e.getRecipients().remove(p);
						}
					}
				}else {
					e.setCancelled(true);
					chatter.sendMessage(ChatColor.WHITE + "[ " + ChatColor.AQUA + "!" + ChatColor.WHITE + " ]" + ChatColor.RED + " 채팅방에 소속되지 않아 말을 할 수 없습니다! /chatroom 으로 채팅방에 가입해주세요!");
				}
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}

}
