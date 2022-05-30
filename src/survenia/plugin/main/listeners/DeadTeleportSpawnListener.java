package survenia.plugin.main.listeners;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

public class DeadTeleportSpawnListener implements Listener {

	@EventHandler
    public void onEntityDeath(EntityDeathEvent event) {
    	
    Entity deadEntity = event.getEntity();
    
    	if(deadEntity instanceof Player) {
    
    		deadEntity.teleport(deadEntity.getWorld().getSpawnLocation());
    	
    	}
    }

}
