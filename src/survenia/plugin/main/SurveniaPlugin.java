package survenia.plugin.main;

import survenia.plugin.main.commands.CommandAnonyme;
import survenia.plugin.main.commands.CommandClearInventory;
import survenia.plugin.main.commands.CommandDypco;
import survenia.plugin.main.commands.CommandeOnePunchMan;
import survenia.plugin.main.commands.CommandeSetSpawn;
import survenia.plugin.main.commands.CommandeSpawn;
import survenia.plugin.main.commands.help.CommandHelp;
import survenia.plugin.main.commands.CommandSRL;
import survenia.plugin.main.listeners.DeadTeleportSpawnListener;
import survenia.plugin.main.listeners.JoinPlayerChatListener;
import survenia.plugin.main.listeners.PlayerInteractListener;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

public class SurveniaPlugin extends JavaPlugin {
	
	@Override
	public void onEnable() {
		//Config.yml
		
		saveDefaultConfig();
		
		//Signal de démarrage du plugin.
		
		System.out.println("-*-");
		System.out.println("Le plugin [Survenia-Plugin] est correctement allumé.");
		System.out.println("-*-");
		
		//Les commandes
		
		getCommand("c").setExecutor(new CommandClearInventory(this));
		getCommand("ano").setExecutor(new CommandAnonyme(this));
		getCommand("dypco").setExecutor(new CommandDypco());
		getCommand("spawn").setExecutor(new CommandeSpawn(this));
		getCommand("setspawn").setExecutor(new CommandeSetSpawn(this));
		getCommand("opm").setExecutor(new CommandeOnePunchMan(this));
		getCommand("srl").setExecutor(new CommandSRL(this));
		getCommand("sphelp").setExecutor(new CommandHelp());
		
		//Les listeners
		
		getServer().getPluginManager().registerEvents(new JoinPlayerChatListener(this), this);
		getServer().getPluginManager().registerEvents(new DeadTeleportSpawnListener(), this);
		getServer().getPluginManager().registerEvents(new PlayerInteractListener(this), this);
		
		//Le BungeeCord
		
		getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
		
		//Messages dans le tchat
		
		new BukkitRunnable()
		  {
		      @Override
		      public void run()
		      {
				Bukkit.broadcastMessage(getConfig().getString("timer.messagestimer.messagechat.messagechatone").replace("&", "§"));
		      }
		  }.runTaskTimer(this, 0, 6000);
		
		new BukkitRunnable()
		  {
		      @Override
		      public void run()
		      {
		          Bukkit.broadcastMessage(getConfig().getString("timer.messagestimer.messagechat.messagechattwo").replace("&", "§"));
		      }
		  }.runTaskTimer(this, 0, 12000);
		
		new BukkitRunnable()
		  {
		      @Override
		      public void run()
		      {
		          Bukkit.broadcastMessage(getConfig().getString("timer.messagestimer.messagechat.messagechatthree").replace("&", "§"));
		      }
		  }.runTaskTimer(this, 0, 18000);
		
	}
	
	@Override
	public void onDisable() {
		
		//Signal d'arrêt du plugin.
		System.out.println("-*-");
		System.out.println("Le plugin [Survenia-Plugin] est correctement éteint.");
		System.out.println("-*-");

	}

}
