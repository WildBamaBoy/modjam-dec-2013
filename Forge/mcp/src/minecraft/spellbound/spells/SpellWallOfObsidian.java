package spellbound.spells;

import spellbound.enums.EnumItemInUseTime;
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
	
	@Override
	public EnumItemInUseTime getSpellDuration() 
	{
		return EnumItemInUseTime.TWO_SECONDS;
	}
}
