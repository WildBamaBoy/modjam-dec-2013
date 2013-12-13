package spellbound.effects;

import spellbound.enums.EnumSpellType;

public class EffectChaos extends AbstractEffect
{
	@Override
	public String getSpellDisplayName() 
	{
		return "Chaos";
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
