package me.failures.main;

import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryInteractEvent;
import org.bukkit.event.player.PlayerExpChangeEvent;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.List;

public class ScaleListener implements Listener {
    private final HealthScaler main;

    public ScaleListener(HealthScaler main) {
        this.main = main;
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    private void healthScaleJoin(PlayerJoinEvent e) {
        List<String> scales = main.getConfig().getStringList("health-scale");
        Player p = e.getPlayer();

        int max = (int)p.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue();
        String[] val = {};
        double a = 20;
        for(String s: scales) {
            val = s.split(":");
            if(max >= Integer.parseInt(val[0])) {
                a = Double.parseDouble(val[1]) * 2;
            }
        }
        p.setHealthScale(a);
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    private void healthScale(PlayerExpChangeEvent e) {
        List<String> scales = main.getConfig().getStringList("health-scale");
        Player p = e.getPlayer();

        int max = (int)p.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue();
        String[] val = {};
        double a = 20;
        for(String s: scales) {
            val = s.split(":");
            if(max >= Integer.parseInt(val[0])) {
                a = Double.parseDouble(val[1]) * 2;
            }
        }
        p.setHealthScale(a);
    }
    @EventHandler(priority = EventPriority.HIGHEST)
    private void healthScale2(InventoryClickEvent e) {
        List<String> scales = main.getConfig().getStringList("health-scale");
        Player p = (Player) e.getWhoClicked();
        int max = (int)p.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue();

        String[] val = {};
        double a = 20;
        for(String s: scales) {
            val = s.split(":");
            if(max >= Integer.parseInt(val[0])) {
                a = Double.parseDouble(val[1]) * 2;
            }
        }
        p.setHealthScale(a);
    }

    private void absorbScale(PlayerExpChangeEvent e) {
        Player p = e.getPlayer();
        p.getAbsorptionAmount();
        
    }
}
