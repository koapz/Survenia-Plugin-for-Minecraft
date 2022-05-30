package survenia.plugin.main.commands;

import java.util.Arrays;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import survenia.plugin.main.SurveniaPlugin;

public class CommandeOnePunchMan implements CommandExecutor {
	
	private SurveniaPlugin main;

	public CommandeOnePunchMan(SurveniaPlugin surveniaPlugin) {
		this.main = surveniaPlugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
		
		if(sender instanceof Player) {
			Player player = (Player) sender;
		
		if(cmd.getName().equalsIgnoreCase("opm")) {
			
			if(args.length == 0) {
				
				ItemStack baton = new ItemStack(Material.STICK, 1);
				
				ItemMeta custombaton = baton.getItemMeta();
				
				custombaton.setDisplayName(main.getConfig().getString("item.itemnameopm").replace("&", "§"));
				custombaton.addEnchant(Enchantment.DAMAGE_ALL, 9999, true);
				custombaton.addEnchant(Enchantment.KNOCKBACK, 100, true);
				custombaton.setLore(Arrays.asList("§cGROSSE TATANE!", "§3by Dypco ;)"));
				custombaton.addItemFlags(ItemFlag.HIDE_ENCHANTS);
				
				baton.setItemMeta(custombaton);
				
				player.getInventory().addItem(baton);
				player.sendMessage(main.getConfig().getString("messages.commands.commandopm").replace("&", "§") + main.getConfig().getString("messages.commands.commandsmessages.commandonepunchman.messagegivedopm").replace("&", "§"));
				player.updateInventory();
				
			}
			
			if(args.length >= 1) {
				
				player.sendMessage(main.getConfig().getString("messages.commands.commandopm").replace("&", "§") + main.getConfig().getString("messages.commands.commandsmessages.commandonepunchman.messageerrorargs").replace("&", "§"));
				
			}
			
			return true;
			
		  }
		
		}
		
		return false;
		
	}

}
