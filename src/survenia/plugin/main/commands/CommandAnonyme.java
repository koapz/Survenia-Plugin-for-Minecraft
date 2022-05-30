package survenia.plugin.main.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import survenia.plugin.main.SurveniaPlugin;

public class CommandAnonyme implements CommandExecutor {
	
	private SurveniaPlugin main;
	
	public CommandAnonyme(SurveniaPlugin surveniaPlugin) {
		this.main = surveniaPlugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
		
		if(sender instanceof Player) {
			Player player = (Player)sender;
			
			//Commande Anonyme
			if(cmd.getName().equalsIgnoreCase("ano")) {
				
				if(args.length == 0) {
					
					player.sendMessage(main.getConfig().getString("messages.commands.commandano").replace("&", "§") + main.getConfig().getString("messages.commands.commandsmessages.commandanomessage.errornoargs").replace("&", "§"));
					
				}
				
				if(args.length >= 1) {
					
					StringBuilder bc = new StringBuilder();
					for(String msgano : args) {
						bc.append(msgano + " ");
						
					}
					
					Bukkit.broadcastMessage(main.getConfig().getString("messages.broadcast.commandano").replace("&", "§") + bc.toString());
					
				}

				return true;
				
			}
			
		}
		
		return false;
	}

}
