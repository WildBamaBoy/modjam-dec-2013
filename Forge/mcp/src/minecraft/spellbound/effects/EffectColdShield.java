package spellbound.effects;

import spellbound.enums.EnumSpellType;

public class EffectColdShield extends AbstractEffect
{
	@Override
	public String getSpellDisplayName() 
	{
		return "Cold Shield";
	}

	@Override
	public void doSpellEffect() 
	{
		
	}

	@Override
	public void updateSpellEffect() 
	{
		
	}
	
	@Override
	public EnumSpellType getSpellType() 
	{
		return EnumSpellType.SELF;
	}
}
