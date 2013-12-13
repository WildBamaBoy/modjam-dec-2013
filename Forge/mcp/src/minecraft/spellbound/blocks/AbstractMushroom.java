package spellbound.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFlower;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;
import spellbound.core.Logic;
import spellbound.core.SB;
import spellbound.effects.AbstractEffect;
import spellbound.util.Coordinates;

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

	/**
	 * SKIP PREFIX
	 * @param textureName
	 * @return
	 */
	public abstract void setTexture();

	/**
	 * Ticks the block if it's been scheduled
	 */
	public void updateTick(World world, int x, int y, int z, Random worldRandom)
	{
		Coordinates nearbyPrimary = Logic.getNearbyBlockTopBottom(world, x, y, z, 1, SB.instance.blockPrimaryMushroomPinkOrange.blockID);

		if (nearbyPrimary != null)
		{
			Coordinates hybridSpawnLocation = Logic.getNearbyBlockTopBottom(world, nearbyPrimary.x, nearbyPrimary.y, nearbyPrimary.z, 1, Block.grass.blockID);
			
			if (hybridSpawnLocation == null)
			{
				hybridSpawnLocation = Logic.getNearbyBlockTopBottom(world, x, y, z, 1, Block.grass.blockID);
			}
			
			if (hybridSpawnLocation != null)
			{
				boolean spawnOrange = SB.rand.nextBoolean() && SB.rand.nextBoolean() && SB.rand.nextBoolean();
				
				if (spawnOrange)
				{
					world.setBlock(hybridSpawnLocation.x, hybridSpawnLocation.y, hybridSpawnLocation.z, SB.instance.blockHybridMushroomOrange.blockID);
				}
				
				else
				{
					world.setBlock(hybridSpawnLocation.x, hybridSpawnLocation.y, hybridSpawnLocation.z, SB.instance.blockHybridMushroomWhite.blockID);
				}
			}
		}
	}

	/**
	 * Checks to see if its valid to put this block at the specified coordinates. Args: world, x, y, z
	 */
	public boolean canPlaceBlockAt(World world, int x, int y, int z)
	{	
		int blockId = world.getBlockId(x, y, z);
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
