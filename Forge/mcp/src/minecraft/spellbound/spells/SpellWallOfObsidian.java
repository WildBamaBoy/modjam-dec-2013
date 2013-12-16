package spellbound.spells;

import net.minecraft.block.Block;

public class SpellWallOfObsidian extends AbstractSpellWall
{
	@Override
	public String getSpellDisplayName() 
	{
		return "Wall of Obsidian";
	}

	@Override
	public int getWallBlockId() 
	{
		return Block.obsidian.blockID;
	}
}
