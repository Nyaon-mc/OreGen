package com.github.nyaon08.rtustudio.og.configuration;

import com.github.nyaon08.rtustudio.og.OreGen;
import kr.rtuserver.framework.bukkit.api.configuration.RSConfiguration;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class OreGenConfig extends RSConfiguration<OreGen> {

    private List<String> ores = List.of(
            "minecraft:stone:10",
            "minecraft:coal_ore:10",
            "minecraft:iron_ore:10",
            "minecraft:gold_ore:10"
    );

    public OreGenConfig(OreGen plugin) {
        super(plugin, "config.yml", 1);
        setup(this);
    }

    private void init() {
        ores = getList("ores", ores, """
                광물 확률
                Ore probability""");
    }

}
