package spellbound.spells;

import spellbound.enums.EnumItemInUseTime;

public class SpellSurgeShield extends AbstractSpellShield
{
	@Override
	public String getSpellDisplayName() 
	{
		return "Surge Shield";
	}

	@Override
	public int getShieldDuration() 
	{
		return 1200;
	}

	@Override
	public EnumItemInUseTime getSpellCastDuration() 
	{
		return EnumItemInUseTime.ONE_SECOND;
	}
}
