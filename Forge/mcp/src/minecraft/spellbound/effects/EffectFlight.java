package spellbound.effects;

import spellbound.enums.EnumSpellType;

public class EffectFlight extends AbstractEffect
{
	@Override
	public String getSpellDisplayName() 
	{
		return "Flight";
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
