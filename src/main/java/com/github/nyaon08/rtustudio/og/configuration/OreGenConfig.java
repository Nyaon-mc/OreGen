package com.github.nyaon08.rtustudio.og.configuration;

import com.github.nyaon08.rtustudio.og.OreGen;
import kr.rtuserver.framework.bukkit.api.configuration.RSConfiguration;
import kr.rtuserver.framework.bukkit.api.registry.CustomItems;
import kr.rtuserver.framework.yaml.configuration.ConfigurationSection;
import lombok.Getter;
import org.bukkit.inventory.ItemStack;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Getter
public class OreGenConfig extends RSConfiguration<OreGen> {

    private final Map<ItemStack, List<String>> cache = new ConcurrentHashMap<>();
    private final Map<ItemStack, Integer> cache2 = new ConcurrentHashMap<>();

    public OreGenConfig(OreGen plugin) {
        super(plugin, "config.yml", 1);
        setup(this);
    }

    public boolean isFenceAvailable(ItemStack itemStack) {
        return cache.containsKey(itemStack);
    }

    public List<String> getItems(ItemStack itemStack) {
        return cache.get(itemStack);
    }

    public int getTick(ItemStack itemStack) {
        return cache2.get(itemStack);
    }

    private void init() {
        ConfigurationSection section = getConfig().getConfigurationSection("fence");

        for (String key : section.getKeys(false)) {
            ConfigurationSection itemSection = section.getConfigurationSection(key);
            if (itemSection == null) continue;

            List<String> items = itemSection.getStringList("ore");
            int tick = itemSection.getInt("tick");

            ItemStack itemStack = CustomItems.from(key);
            cache.put(itemStack, items);
            cache2.put(itemStack, tick);
        }
    }

}
