package spellbound.spells;

import spellbound.enums.EnumItemInUseTime;

public class SpellFireShield extends AbstractSpellShield
{
	@Override
	public String getSpellDisplayName() 
	{
		return "Fire Shield";
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
