package spellbound.effects;

import spellbound.enums.EnumSpellType;

public class EffectBreach extends AbstractEffect
{
	@Override
	public String getSpellDisplayName() 
	{
		return "Breach";
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
