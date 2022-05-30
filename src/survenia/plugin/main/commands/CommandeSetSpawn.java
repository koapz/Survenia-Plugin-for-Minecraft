package survenia.plugin.main.commands;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import survenia.plugin.main.SurveniaPlugin;

public class CommandeSetSpawn implements CommandExecutor {
	
	private SurveniaPlugin main;

	public CommandeSetSpawn(SurveniaPlugin surveniaPlugin) {
		this.main = surveniaPlugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
		
		if(sender instanceof Player) {
			Player player = (Player)sender;
		
			if(cmd.getName().equalsIgnoreCase("setspawn")) {
			
			 if(args.length == 0) {
				
				World world = player.getWorld(); // world est chargé de savoir dans quel monde est le joueur
				Location loc = player.getLocation(); // location est chargé de savoir la position exacte du joueur
				world.setSpawnLocation(loc); // on place le spawn sur la position du joueur
				player.sendMessage(main.getConfig().getString("messages.commands.commandspawn").replace("&", "§") + main.getConfig().getString("messages.commands.commandsmessages.commandsetspawn.messagesetspawndefined").replace("&", "§")); 
				
			}
			
			 if(args.length >= 1) {
				
				player.sendMessage(main.getConfig().getString("messages.commands.commandspawn").replace("&", "§") + main.getConfig().getString("messages.commands.commandsmessages.commandsetspawn.messageerrorargs").replace("&", "§"));
				
			}
			
			return true;
				
		  }
		
		}
		
		return false;
		
	}

}
