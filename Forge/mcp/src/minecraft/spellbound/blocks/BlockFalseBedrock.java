/**********************************************
 * BlockFalseBedrock.java
 * Copyright (c) 2013 Wild Bama Boy.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl.html
 **********************************************/

package spellbound.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.world.World;
import spellbound.core.SpellboundCore;

public class BlockFalseBedrock extends Block
{
	public BlockFalseBedrock(int blockId) 
	{
		super(blockId, Material.rock);
		this.setBlockUnbreakable();
		this.setResistance(6000000.0F);
		this.setStepSound(soundStoneFootstep);
		this.setUnlocalizedName("spellboundbedrock");
		this.disableStats();
		this.setCreativeTab(CreativeTabs.tabBlock);
		this.setTextureName("bedrock");
		this.setTickRandomly(true);
	}

	@Override
	public void updateTick(World world, int posX, int posY, int posZ, Random random) 
	{
		if (SpellboundCore.modRandom.nextBoolean())
		{
			world.setBlock(posX, posY, posZ, 0);
		}
	}
}
