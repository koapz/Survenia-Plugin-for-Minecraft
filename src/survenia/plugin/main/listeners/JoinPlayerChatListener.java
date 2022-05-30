package survenia.plugin.main.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import survenia.plugin.main.SurveniaPlugin;

import org.bukkit.event.EventHandler;

public class JoinPlayerChatListener implements Listener {
	
	private SurveniaPlugin main;
	
	public JoinPlayerChatListener(SurveniaPlugin surveniaPlugin) {
		this.main = surveniaPlugin;
	}
	
	@EventHandler
	public void onJoin(PlayerJoinEvent pje) {
		
		Player player = pje.getPlayer();
		player.teleport(player.getWorld().getSpawnLocation());
		pje.setJoinMessage(main.getConfig().getString("messages.joindisconnectplayer.connectanddisconnect").replace("&", "§") + main.getConfig().getString("messages.joindisconnectplayer.connectpartone").replace("&", "§") + player.getName() + main.getConfig().getString("messages.joindisconnectplayer.connectparttwo").replace("&", "§"));
			
		player.sendMessage(main.getConfig().getString("messages.joindisconnectplayer.messageone").replace("&", "§"));
		player.sendMessage(main.getConfig().getString("messages.joindisconnectplayer.messagetwo").replace("&", "§"));
		
	}
	
	@EventHandler
	public void onQuit(PlayerQuitEvent pqe) {
		
		Player player = pqe.getPlayer();
		
		pqe.setQuitMessage(main.getConfig().getString("messages.joindisconnectplayer.connectanddisconnect").replace("&", "§") + main.getConfig().getString("messages.joindisconnectplayer.disconnectpartone").replace("&", "§") + player.getName() + main.getConfig().getString("messages.joindisconnectplayer.disconnectparttwo").replace("&", "§"));
		
	}

}
