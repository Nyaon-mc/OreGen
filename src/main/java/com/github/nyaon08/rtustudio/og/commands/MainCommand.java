package com.github.nyaon08.rtustudio.og.commands;

import com.github.nyaon08.rtustudio.og.OreGen;
import com.github.nyaon08.rtustudio.og.configuration.OreGenConfig;
import kr.rtuserver.framework.bukkit.api.command.RSCommand;
import kr.rtuserver.framework.bukkit.api.command.RSCommandData;
import org.bukkit.permissions.PermissionDefault;

public class MainCommand extends RSCommand<OreGen> {

    private final OreGenConfig oreGenConfig;

    public MainCommand(OreGen plugin) {
        super(plugin, "oregen", PermissionDefault.OP);
        oreGenConfig = plugin.getOreGenConfig();
    }

    @Override
    protected void reload(RSCommandData data) {
        oreGenConfig.reload();
    }

}