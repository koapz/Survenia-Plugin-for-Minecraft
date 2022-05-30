package survenia.plugin.main.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import survenia.plugin.main.SurveniaPlugin;

public class CommandSRL implements CommandExecutor {
	
	private SurveniaPlugin surveniaPlugin;

	public CommandSRL(SurveniaPlugin surveniaPlugin) {
		this.surveniaPlugin = surveniaPlugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
		
		if(sender instanceof Player) {
			Player player = (Player)sender;
			
			if(cmd.getName().equalsIgnoreCase("srl")) {
				
				if(args.length == 0) {
					
					new BukkitRunnable() {
						private int time = 10;

						@Override
						public void run() {
							if(time == 0) {
								Bukkit.broadcastMessage(surveniaPlugin.getConfig().getString("messages.commands.commandsrl").replace("&", "§") + surveniaPlugin.getConfig().getString("messages.commands.commandsmessages.commandsrl.messagereloading").replace("&", "§"));
								Bukkit.dispatchCommand(player, "rl");
								Bukkit.broadcastMessage(surveniaPlugin.getConfig().getString("messages.commands.commandsrl").replace("&", "§") + surveniaPlugin.getConfig().getString("messages.commands.commandsmessages.commandsrl.messagereloadingfinished").replace("&", "§"));
								cancel();
							} else {
								Bukkit.broadcastMessage(surveniaPlugin.getConfig().getString("messages.commands.commandsrl").replace("&", "§") + surveniaPlugin.getConfig().getString("messages.commands.commandsmessages.commandsrl.messagetimerreloadpartone").replace("&", "§") + time + surveniaPlugin.getConfig().getString("messages.commands.commandsmessages.commandsrl.messagetimerreloadparttwo").replace("&", "§"));
								time--;
							}
							
						}
						
					}.runTaskTimer(surveniaPlugin, 0, 20);
					
				}
				
				if(args.length >= 1) {
					player.sendMessage(surveniaPlugin.getConfig().getString("messages.commands.commandsmessages.commandsrl.messageerrorargs").replace("&", "§"));
				}

				return true;
			}
			
		}
		
		return false;
		
	}

}