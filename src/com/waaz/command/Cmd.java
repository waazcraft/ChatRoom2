package com.waaz.command;

import java.io.IOException;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.waaz.gui.Gui;

public class Cmd implements CommandExecutor {
	Gui gui = new Gui();

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(!(sender instanceof Player))
		{
			sender.sendMessage("Only 인게임.");
		}
		
		Player pl = (Player) sender;
		if(pl.hasPermission("cr.select"))
		{
			try {
				gui.openChat(pl);
				return true;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else {
			pl.sendMessage(ChatColor.RED + "권한이 없습니다!");
			return false;
		}
 		
		return false;
	}
	
	

}
