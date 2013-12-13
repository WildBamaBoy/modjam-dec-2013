package spellbound.effects;

import spellbound.enums.EnumSpellType;

public class EffectBlink extends AbstractEffect
{
	@Override
	public String getSpellDisplayName() 
	{
		return "Blink";
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
