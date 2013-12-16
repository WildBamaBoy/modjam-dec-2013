package spellbound.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.world.World;

public class BlockFalseBedrock extends Block
{
	public BlockFalseBedrock(int par1) 
	{
		super(par1, Material.rock);
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
	public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random) 
	{
		par1World.setBlock(par2, par3, par4, 0);
	}
}
