package spellbound.effects;

import spellbound.enums.EnumSpellType;

public class EffectSurgeShield extends AbstractEffect
{
	@Override
	public String getSpellDisplayName() 
	{
		return "Surge Shield";
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
