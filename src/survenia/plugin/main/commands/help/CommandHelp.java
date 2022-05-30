package survenia.plugin.main.commands.help;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandHelp implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
		
		if(sender instanceof Player) {
			Player p = (Player) sender;
			
			if(cmd.getName().equalsIgnoreCase("sphelp")) {
				
					p.sendMessage("§4§l____________________________");
					p.sendMessage("§4§l_                                     §4§l_");
					p.sendMessage("§4§l_  §e-*-   §6§lSurv§4§lenia§3§l-§a§lPlugins   §e-*-    §4§l_");
					p.sendMessage("§4§l____________________________");
					p.sendMessage(" ");
					p.sendMessage("§3~§6*§3~§6*§3~");
					p.sendMessage("§d1. §e§l-§6§l> §c§l/spawn §a= §3permet de se téléporter vers le spawn.");
					p.sendMessage("§d2. §e§l-§6§l> §c§l/setspawn §a= §3permet de placer le spawn.");
					p.sendMessage("§d3. §e§l-§6§l> §c§l/c §a= §3permet de clear son inventaire. ");
					p.sendMessage("§d4. §e§l-§6§l> §c§l/dypco §a= §3:-)");
					p.sendMessage("§d5. §e§l-§6§l> §c§l/ano §a= §3permet d'écrire un message en étant inconnu.");
					p.sendMessage("§d6. §e§l-§6§l> §c§l/opm §a= §3la sainte §4§lTATANE§6§l!");
					p.sendMessage("§d7. §e§l-§6§l> §c§l/srl §a= §3permet de rafraichir le serveur.");
					/*p.sendMessage("§d8. §e§l-§6§l> §c§l");
					p.sendMessage("§d9. §e§l-§6§l> §c§l");
					p.sendMessage("§d10. §e§l-§6§l> §c§l");*/
					p.sendMessage(" ");
					p.sendMessage("§3~§6*§3~§6*§3~");
					
				
			}
			
		}
		
		return false;
	}

}
