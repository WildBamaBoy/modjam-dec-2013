package spellbound.spells;

import net.minecraft.block.Block;

public class SpellWallOfStone extends AbstractSpellWall
{
	@Override
	public String getSpellDisplayName() 
	{
		return "Wall of Stone";
	}

	@Override
	public int getWallBlockId() 
	{
		return Block.stone.blockID;
	}
}
