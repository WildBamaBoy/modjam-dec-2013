package spellbound.effects;

import spellbound.enums.EnumSpellType;

public class EffectTransport extends AbstractEffect
{
	@Override
	public String getSpellDisplayName() 
	{
		return "Transport";
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
		return EnumSpellType.TARGET;
	}
}
