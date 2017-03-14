package me.abcric.bukkit.nobabyzombies;

import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class NoBabyZombies extends JavaPlugin implements Listener {
	@Override
	public void onEnable() {
		getLogger().info("Starting up " + getDescription().getName() + " " + getDescription().getVersion() + " by "
				+ String.join(", ", getDescription().getAuthors()) + "...");
		getServer().getPluginManager().registerEvents(this, this);
		getLogger().info("Enabled.");
	}

	@EventHandler(ignoreCancelled = true)
	public void onEntitySpawnEvent(EntitySpawnEvent event) {
		Entity ent = event.getEntity();
		if (ent.getType() == EntityType.ZOMBIE && ((Zombie) ent).isBaby()) {
			((Zombie) ent).setBaby(false);
		}
	}
}