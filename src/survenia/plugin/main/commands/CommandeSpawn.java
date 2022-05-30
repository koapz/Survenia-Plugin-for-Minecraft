package survenia.plugin.main.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import survenia.plugin.main.SurveniaPlugin;

public class CommandeSpawn implements CommandExecutor {
	
	private SurveniaPlugin main;

	public CommandeSpawn(SurveniaPlugin surveniaPlugin) {
		this.main = surveniaPlugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if(sender instanceof Player) {
			Player player = (Player)sender;
			
			if(cmd.getName().equalsIgnoreCase("spawn")) {
				
				if(args.length == 0) {
					
					player.sendMessage(main.getConfig().getString("messages.commands.commandspawn").replace("&", "§") + main.getConfig().getString("messages.commands.commandsmessages.commandspawn.messagetpspawn").replace("&", "§"));
					player.teleport(player.getWorld().getSpawnLocation());
					
				}
				
				if(args.length >= 1) {
					
					player.sendMessage(main.getConfig().getString("messages.commands.commandspawn").replace("&", "§") + main.getConfig().getString("messages.commands.commandsmessages.commandspawn.messageerrorargs").replace("&", "§"));
					
				}
				
				return true;
				
			}
			
		}
		
	return false;
	
	}

}
