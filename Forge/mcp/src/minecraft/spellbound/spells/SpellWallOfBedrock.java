package spellbound.spells;

import spellbound.core.SpellboundCore;
import spellbound.enums.EnumItemInUseTime;

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
		return SpellboundCore.instance.blockFalseBedrock.blockID;
	}
	
	@Override
	public EnumItemInUseTime getSpellCastDuration() 
	{
		return EnumItemInUseTime.FOUR_SECONDS;
	}
}
