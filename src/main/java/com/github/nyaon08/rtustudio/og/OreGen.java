package com.github.nyaon08.rtustudio.og;

import com.github.nyaon08.rtustudio.og.commands.MainCommand;
import com.github.nyaon08.rtustudio.og.configuration.OreGenConfig;
import com.github.nyaon08.rtustudio.og.listeners.BlockFlowListener;
import kr.rtuserver.framework.bukkit.api.RSPlugin;
import lombok.Getter;

public class OreGen extends RSPlugin {

    @Getter
    private static OreGen instance;

    @Getter
    private OreGenConfig oreGenConfig;

    @Override
    public void load() {
        instance = this;
    }

    @Override
    public void enable() {
        oreGenConfig = new OreGenConfig(this);
        registerCommand(new MainCommand(this), true);
        registerEvent(new BlockFlowListener(this));
    }

    @Override
    public void disable() {
        instance = null;
    }

}
