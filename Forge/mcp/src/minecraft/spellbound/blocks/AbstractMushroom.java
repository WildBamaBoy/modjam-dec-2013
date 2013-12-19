/**********************************************
 * AbstractMushroom.java
 * Copyright (c) 2013 Wild Bama Boy.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl.html
 **********************************************/

package spellbound.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFlower;
import net.minecraft.world.World;
import spellbound.core.SpellboundCore;
import spellbound.core.util.Logic;
import spellbound.core.util.Point3DBlock;
import spellbound.spells.AbstractSpell;

public abstract class AbstractMushroom extends BlockFlower
{
	public AbstractMushroom(int itemId) 
	{
		super(itemId);
		this.setBlockBounds(0.5F - 0.2F, 0.0F, 0.5F - 0.2F, 0.5F + 0.2F, 0.2F * 2.0F, 0.5F + 0.2F);
		this.setTickRandomly(true);
		this.setCreativeTab(SpellboundCore.getInstance().spellboundTab);

		this.setName();
		this.setTexture();
	}

	public abstract AbstractSpell getMushroomSpell();

	public abstract void setName();

	public abstract void setTexture();

	public abstract int[] getMateIds();
	
	public abstract int getOffspringId(int mateId);
	
	@Override
	public void updateTick(World world, int posX, int posY, int posZ, Random random)
	{
		final Point3DBlock nearbyPrimary = Logic.getNearbyMushroomMate(this, world, posX, posY, posZ, 1, this.getMateIds());

		if (nearbyPrimary != null)
		{
			//Try to get a spawn near the primary first.
			Point3DBlock hybridSpawn = Logic.getNearbyMushroomSpawn(world, nearbyPrimary.posX, nearbyPrimary.posY, nearbyPrimary.posZ, 1);
			
			//Check to see if it succeeded.
			if (hybridSpawn == null)
			{
				//If it didn't, try to find a spot around this mushroom's position for the new mushroom to spawn.
				hybridSpawn = Logic.getNearbyMushroomSpawn(world, posX, posY, posZ, 1);
			}
			
			//Now test again to see if a spot was found around this mushroom and spawn the new mushroom if it was.
			if (hybridSpawn != null)
			{
				world.setBlock(hybridSpawn.posX, hybridSpawn.posY, hybridSpawn.posZ, nearbyPrimary.blockId);
			}
		}
	}

	@Override
	public boolean canPlaceBlockAt(World world, int posX, int posY, int posZ)
	{
		final int blockId = world.getBlockId(posX, posY - 1, posZ);
		return blockId == Block.grass.blockID || blockId == Block.dirt.blockID;
	}

	@Override
	protected boolean canThisPlantGrowOnThisBlockID(int blockID)
	{
		return Block.opaqueCubeLookup[blockID];
	}
}
