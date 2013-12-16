package spellbound.spells;

import net.minecraft.block.Block;
import spellbound.enums.EnumItemInUseTime;

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
