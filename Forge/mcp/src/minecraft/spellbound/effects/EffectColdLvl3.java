package spellbound.effects;

import spellbound.enums.EnumSpellType;

public class EffectColdLvl3 extends AbstractEffect
{
	@Override
	public String getSpellDisplayName() 
	{
		return "Cold Blast";
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
		return EnumSpellType.FRONT;
	}
}
