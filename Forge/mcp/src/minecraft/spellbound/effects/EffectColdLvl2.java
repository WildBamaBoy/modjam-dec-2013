package spellbound.effects;

import spellbound.enums.EnumSpellType;

public class EffectColdLvl2 extends AbstractEffect
{
	@Override
	public String getSpellDisplayName() 
	{
		return "Icicle";
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
