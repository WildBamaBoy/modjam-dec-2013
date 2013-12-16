package spellbound.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFlower;
import net.minecraft.world.World;
import spellbound.core.Logic;
import spellbound.core.SpellboundCore;
import spellbound.spells.AbstractSpell;
import spellbound.util.MushroomCoordinates;

public abstract class AbstractMushroom extends BlockFlower
{
	public AbstractMushroom(int itemId) 
	{
		super(itemId);
		this.setBlockBounds(0.5F - 0.2F, 0.0F, 0.5F - 0.2F, 0.5F + 0.2F, 0.2F * 2.0F, 0.5F + 0.2F);
		this.setTickRandomly(true);
		this.setCreativeTab(SpellboundCore.instance.spellboundTab);

		this.setName();
		this.setTexture();
	}

	public abstract AbstractSpell getMushroomSpell();

	public abstract void setName();

	public abstract void setTexture();

	public abstract int[] getMateIds();
	
	public abstract int getOffspringId(int mateId);
	
	public void updateTick(World world, int x, int y, int z, Random worldRandom)
	{

	}

	/**
	 * Checks to see if its valid to put this block at the specified coordinates. Args: world, x, y, z
	 */
	public boolean canPlaceBlockAt(World world, int x, int y, int z)
	{		
		MushroomCoordinates nearbyPrimary = Logic.getNearbyMushroomMate(this, world, x, y, z, 1, this.getMateIds());

		if (nearbyPrimary != null)
		{
			MushroomCoordinates hybridSpawn = Logic.getNearbyMushroomSpawn(world, nearbyPrimary.x, nearbyPrimary.y, nearbyPrimary.z, 1, Block.grass.blockID);
			
			if (hybridSpawn == null)
			{
				hybridSpawn = Logic.getNearbyMushroomSpawn(world, x, y, z, 1, Block.grass.blockID);
			}
			
			if (hybridSpawn != null)
			{
				world.setBlock(hybridSpawn.x, hybridSpawn.y, hybridSpawn.z, nearbyPrimary.spawnId);
			}
		}
		
		int blockId = world.getBlockId(x, y - 1, z);
		return blockId == Block.grass.blockID || blockId == Block.dirt.blockID;
	}

	/**
	 * Gets passed in the blockID of the block below and supposed to return true if its allowed to grow on the type of
	 * blockID passed in. Args: blockID
	 */
	protected boolean canThisPlantGrowOnThisBlockID(int blockID)
	{
		return Block.opaqueCubeLookup[blockID];
	}

	/**
	 * Can this block stay at this position.  Similar to canPlaceBlockAt except gets checked often with plants.
	 */
	public boolean canBlockStay(World world, int x, int y, int z)
	{
		//TODO: THIS
		return true;
	}
}
