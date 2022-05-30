package survenia.plugin.main.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import survenia.plugin.main.SurveniaPlugin;

public class CommandClearInventory implements CommandExecutor {
	
	private SurveniaPlugin main;

	public CommandClearInventory(SurveniaPlugin surveniaPlugin) {
		this.main = surveniaPlugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
		
		if(sender instanceof Player) {
			Player player = (Player) sender;
			
			if(cmd.getName().equalsIgnoreCase("c")) {
				
				if(args.length == 0 && player.getInventory().isEmpty() == false) {
					
					player.getInventory().clear();
					player.updateInventory();
					player.sendMessage(main.getConfig().getString("messages.commands.commandclearinventory").replace("&", "§") + main.getConfig().getString("messages.commands.commandsmessages.commandclearinventorymessage.messagecleared").replace("&", "§"));
					
				} 
				
				else if(args.length >= 1 || !player.getInventory().isEmpty()) {
					
					player.sendMessage(main.getConfig().getString("messages.commands.commandclearinventory").replace("&", "§") + main.getConfig().getString("messages.commands.commandsmessages.commandclearinventorymessage.messageerrorargs").replace("&", "§"));
					
				}

				else if(player.getInventory().isEmpty() == true) {
					
					player.sendMessage(main.getConfig().getString("messages.commands.commandclearinventory").replace("&", "§") + main.getConfig().getString("messages.commands.commandsmessages.commandclearinventorymessage.messageerroralreadycleared").replace("&", "§"));
				
				}
				
				return true;
				
			}
		
	}
	
	return false;
		
}}
