package com.github.nyaon08.rtustudio.og.listeners;

import com.github.nyaon08.rtustudio.og.OreGen;
import com.github.nyaon08.rtustudio.og.util.MaterialSelector;
import com.github.nyaon08.rtustudio.og.util.MaterialUtil;
import kr.rtuserver.framework.bukkit.api.listener.RSListener;
import kr.rtuserver.framework.bukkit.api.registry.CustomBlocks;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.data.BlockData;
import org.bukkit.block.data.type.Fence;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockFromToEvent;

public class BlockFlowListener extends RSListener<OreGen> {

    public BlockFlowListener(OreGen plugin) {
        super(plugin);
    }

    @EventHandler
    public void onBlockFromToEvent(BlockFromToEvent event) {
        Block toBlock = event.getToBlock();
        Block fenceBlock = toBlock.getRelative(BlockFace.DOWN);

        if (toBlock.getType() == Material.AIR &&
                fenceBlock.getBlockData() instanceof Fence) {

            event.setCancelled(true);
            generateCustomBlock(toBlock);
        }
    }

    private void generateCustomBlock(Block block) {
        Location location = block.getLocation();
        World world = location.getWorld();

        if (world != null) {
            String materialStr = MaterialUtil.getRandomBlockData(new MaterialSelector().chooseBlock(getPlugin()));
            BlockData blockData = CustomBlocks.from(materialStr);
            if (blockData != null) {
                block.setBlockData(blockData);
            }
        }
    }
}
