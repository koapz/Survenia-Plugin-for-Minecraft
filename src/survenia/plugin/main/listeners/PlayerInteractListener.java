package survenia.plugin.main.listeners;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.block.BlockState;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import survenia.plugin.main.SurveniaPlugin;

public class PlayerInteractListener implements Listener {
	
	private SurveniaPlugin main;
	
	public PlayerInteractListener(SurveniaPlugin surveniaPlugin) {
		this.main = surveniaPlugin;
	}

	@EventHandler
	public void onInteract(PlayerInteractEvent pie) {
		
		Player player = pie.getPlayer();
		Action action = pie.getAction();
		
		if(pie.getClickedBlock() != null && action == Action.RIGHT_CLICK_BLOCK) {
			
			BlockState bs = pie.getClickedBlock().getState();
			if(bs instanceof Sign) {
				Sign sign = (Sign) bs;
				
				if(sign.getLine(0).equals("[ClearInventaire]") && sign.getLine(1).equals("by Dypco")) {
					player.getInventory().clear();
					player.sendMessage("§a§lL'inventaire à était cleared.");
				}
				
				if(sign.getLine(0).equals(main.getConfig().getString("signtp.sign1.line0").replace("&", "§")) && sign.getLine(1).equals(main.getConfig().getString("signtp.sign1.line1").replace("&", "§")) && sign.getLine(2).equals(main.getConfig().getString("signtp.sign1.line2").replace("&", "§")) && sign.getLine(3).equals(main.getConfig().getString("signtp.sign1.line3").replace("&", "§"))) {
					
					String world = main.getConfig().getString("signtp.worldtpsign.world");
					double coordsX = main.getConfig().getInt("signtp.coords.coordsX");
					double coordsY = main.getConfig().getInt("signtp.coords.coordsY");
					double coordsZ = main.getConfig().getInt("signtp.coords.coordsZ");
					float coordsvuleftright = main.getConfig().getInt("signtp.coords.coordsvuleftright");
					float coordsvuupdown = main.getConfig().getInt("signtp.coords.coordsvuupdown");
																		                           							                                                                       
					Location loc = new Location(Bukkit.getWorld(world), coordsX, coordsY, coordsZ, coordsvuleftright, coordsvuupdown);
					
					if(player.isOp() == true && main.getConfig().getBoolean("signtp.sign1.permission")) {
						
						player.sendMessage(main.getConfig().getString("signtp.messagesigntp.messagesone").replace("&", "§"));
						player.teleport(loc);
						player.sendMessage(main.getConfig().getString("signtp.messagesigntp.messagestwocoffre").replace("&", "§"));
						
					} else if(player.isOp() == false) {
						
						player.sendMessage(main.getConfig().getString("signtp.messagesigntp.messagenoaccesssignadmin").replace("&", "§"));
						
					}
					
				}
			}
			
		}
		
	}

}
