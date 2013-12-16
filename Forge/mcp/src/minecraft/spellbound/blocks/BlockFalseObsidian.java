package spellbound.blocks;

import net.minecraft.block.BlockObsidian;
import net.minecraft.block.material.Material;

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
	}
}
