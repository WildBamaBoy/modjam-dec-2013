package spellbound.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFlower;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;
import spellbound.core.SB;
import spellbound.effects.AbstractEffect;

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
	public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random)
	{

	}

	/**
	 * Checks to see if its valid to put this block at the specified coordinates. Args: world, x, y, z
	 */
	public boolean canPlaceBlockAt(World par1World, int par2, int par3, int par4)
	{
		int myId = par1World.getBlockId(par2, par3, par4);

		int squareCounter = -1;

		//TODO RENAME
		while (squareCounter < 2)
		{
			for (int i = -1; i < 2; i++)
			{
				if (par1World.getBlockId(par2 + squareCounter, par3, par4 + i) == SB.instance.blockPrimaryMushroomPinkOrange.blockID)
				{
					//TODO Move rand to SB
					Random rand = new Random();

					//Search for possible location.
					int searchCounter = 0;

					boolean spawnPointFound = false;
					int spawnX = 0;
					int spawnY = 0;
					int spawnZ = 0;

					while (searchCounter < 2)
					{
						for (int j = -1; j < 2; j++)
						{
							spawnPointFound = par1World.getBlockId(par2 + searchCounter, par3, par4 + j) == 0;

							if (spawnPointFound)
							{
								spawnX = par2 + searchCounter;
								spawnY = par3;
								spawnZ = par4 + j;
								break;
							}
						}
						
						if (spawnPointFound)
						{
							searchCounter++;
						}
					}

					if (spawnPointFound)
					{
						if (rand.nextBoolean() && rand.nextBoolean() && rand.nextBoolean() && rand.nextBoolean())
						{
							par1World.setBlock(spawnX, spawnY, spawnZ, SB.instance.blockHybridMushroomOrange.blockID);
						}

						else
						{
							par1World.setBlock(spawnX, spawnY, spawnZ, SB.instance.blockHybridMushroomWhite.blockID);
						}
					}
					break;
				}
			}

			squareCounter++;
		}

		return par1World.getBlockId(par2, par3 - 1, par4) == Block.grass.blockID;
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
