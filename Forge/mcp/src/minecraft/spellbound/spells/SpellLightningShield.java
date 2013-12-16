package spellbound.spells;

import spellbound.enums.EnumItemInUseTime;

public class SpellLightningShield extends AbstractSpellShield
{
	@Override
	public String getSpellDisplayName() 
	{
		return "Lightning Shield";
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
