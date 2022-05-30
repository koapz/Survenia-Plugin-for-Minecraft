package survenia.plugin.main.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandDypco implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
		
		if(sender instanceof Player) {
			Player player = (Player)sender;	
			
			//Commande Secret Dypco
			if(cmd.getName().equalsIgnoreCase("dypco")) {
				
				if(args.length == 0) {
					
					player.sendMessage("§6Dypco §4est le créateur des plugins de Survenia :-)");
					
				}
				
				if(args.length >= 1) {
					
					player.sendMessage("§4§lErreur: Tu es con ou quoi, la commande n'accepte aucun arguments gros fils de pute !");
					
				}
				
				return true;	
				
			  }
			
		}
		
		return false;
	}

}
