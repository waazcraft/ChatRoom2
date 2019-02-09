package com.waaz.main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import com.waaz.command.Cmd;
import com.waaz.event.EventListener;

public class Main extends JavaPlugin {
	
	File folder1 = new File("plugins/ChatRoom");
	
	@Override 
	public void onEnable()
	{
		this.getCommand("chatroom").setExecutor(new Cmd());
		folder1.mkdir();
		Bukkit.getPluginManager().registerEvents(new EventListener(), this);
		loadConfig();
	}
	
	public void loadConfig() 
	{
		getConfig().options().copyDefaults(true);
		saveConfig();
	}
	
	public static int readPF(UUID uniq) throws IOException
	{
		File chatroom = new File("plugins/ChatRoom/" + String.valueOf(uniq) + ".txt");
		try {
			BufferedReader br = new BufferedReader(new FileReader(chatroom));
			String s = br.readLine();
			int chat = Integer.parseInt(s);
			br.close();
			if(chat != 0)
			{
				if(chat > 1)
				{
					if(chat >2)
					{
						if(chat > 3)
						{
							return 4;
						}else {
							return 3;
						}
					}else {
						return 2;
					}
				}else {
					return 1;
				}
			}else {
				return 0;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public static void writePF(UUID uniq, int i)
	{
		File chatroom = new File("plugins/ChatRoom/" + String.valueOf(uniq) + ".txt");
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(chatroom));
			bw.append(String.valueOf(i));
			bw.flush();
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}

}
