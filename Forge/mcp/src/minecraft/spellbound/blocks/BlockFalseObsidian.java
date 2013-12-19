/**********************************************
 * BlockFalseObsidian.java
 * Copyright (c) 2013 Wild Bama Boy.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl.html
 **********************************************/

package spellbound.blocks;

import java.util.Random;

import net.minecraft.block.BlockObsidian;
import net.minecraft.world.World;

public class BlockFalseObsidian extends BlockObsidian
{
	public BlockFalseObsidian(int blockId)
	{
		super(blockId);
		this.setHardness(50.0F);
		this.setResistance(2000.0F);
		this.setStepSound(soundStoneFootstep);
		this.setUnlocalizedName("spellboundobsidian");
		this.setTextureName("obsidian");
		this.setTickRandomly(true);
	}

	@Override
	public void updateTick(World world, int posX, int posY, int posZ, Random random) 
	{
		world.setBlock(posX, posY, posZ, 0);
	}
}
