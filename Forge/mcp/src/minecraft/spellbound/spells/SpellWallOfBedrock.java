package spellbound.spells;

import net.minecraft.block.Block;

public class SpellWallOfBedrock extends AbstractSpellWall
{
	@Override
	public String getSpellDisplayName() 
	{
		return "Wall of Bedrock";
	}

	@Override
	public int getWallBlockId() 
	{
		return Block.bedrock.blockID;
	}
}
