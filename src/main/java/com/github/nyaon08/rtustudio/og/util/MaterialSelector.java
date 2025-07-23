package com.github.nyaon08.rtustudio.og.util;

import com.github.nyaon08.rtustudio.og.OreGen;
import com.github.nyaon08.rtustudio.og.configuration.OreGenConfig;
import com.github.nyaon08.rtustudio.og.model.OgMaterial;
import kr.rtuserver.framework.bukkit.api.registry.CustomItems;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class MaterialSelector {

    public List<OgMaterial> chooseBlock(OreGen plugin, ItemStack itemStack) {
        OreGenConfig oreGenConfig = plugin.getOreGenConfig();
        List<OgMaterial> defaultOres = new ArrayList<>();

        for (String gen : oreGenConfig.getItems(itemStack)) {
            String[] split = gen.split(":");
            if (split.length < 2) continue;

            String materialStr = gen.substring(0, gen.lastIndexOf(':'));
            int probability = Integer.parseInt(split[split.length - 1]);

            if (CustomItems.from(materialStr) != null) {
                defaultOres.add(new OgMaterial(materialStr, probability));
            }
        }

        return defaultOres;
    }

}
