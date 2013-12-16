package spellbound.spells;

import spellbound.core.SpellboundCore;
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
		return SpellboundCore.instance.blockFalseObsidian.blockID;
	}
	
	@Override
	public EnumItemInUseTime getSpellCastDuration() 
	{
		return EnumItemInUseTime.TWO_SECONDS;
	}
}
