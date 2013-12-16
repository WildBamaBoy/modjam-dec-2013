package spellbound.blocks;

import java.util.Random;

import net.minecraft.block.BlockObsidian;
import net.minecraft.world.World;

public class BlockFalseObsidian extends BlockObsidian
{
	public BlockFalseObsidian(int par1)
	{
		super(par1);
		this.setHardness(50.0F);;
		this.setResistance(2000.0F);
		this.setStepSound(soundStoneFootstep);
		this.setUnlocalizedName("spellboundobsidian");
		this.setTextureName("obsidian");
		this.setTickRandomly(true);
	}

	@Override
	public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random) 
	{
		par1World.setBlock(par2, par3, par4, 0);
	}
}
