package spellbound.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFlower;
import net.minecraft.world.World;
import spellbound.core.Logic;
import spellbound.core.SB;
import spellbound.effects.AbstractEffect;
import spellbound.util.MushroomCoordinates;

public abstract class AbstractMushroom extends BlockFlower
{
	public AbstractMushroom(int itemId) 
	{
		super(itemId);
		this.setBlockBounds(0.5F - 0.2F, 0.0F, 0.5F - 0.2F, 0.5F + 0.2F, 0.2F * 2.0F, 0.5F + 0.2F);
		this.setTickRandomly(true);
		this.setCreativeTab(SB.instance.spellboundTab);

		this.setName();
		this.setTexture();
	}

	public abstract AbstractEffect getMushroomEffect();

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
		MushroomCoordinates nearbyPrimary = Logic.getNearbyBlockTopBottom(this, world, x, y, z, 1, this.getMateIds());

		if (nearbyPrimary != null)
		{
			MushroomCoordinates hybridSpawn = Logic.getNearbyBlockTopBottom(world, nearbyPrimary.x, nearbyPrimary.y, nearbyPrimary.z, 1, Block.grass.blockID);
			
			if (hybridSpawn == null)
			{
				hybridSpawn = Logic.getNearbyBlockTopBottom(world, x, y, z, 1, Block.grass.blockID);
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
	protected boolean canThisPlantGrowOnThisBlockID(int par1)
	{
		return Block.opaqueCubeLookup[par1];
	}

	/**
	 * Can this block stay at this position.  Similar to canPlaceBlockAt except gets checked often with plants.
	 */
	public boolean canBlockStay(World par1World, int par2, int par3, int par4)
	{
		return true;
		//TODO: THIS
	}
}
