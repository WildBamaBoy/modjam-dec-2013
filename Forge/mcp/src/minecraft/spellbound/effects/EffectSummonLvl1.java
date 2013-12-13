package spellbound.effects;

import spellbound.enums.EnumSpellType;

public class EffectSummonLvl1 extends AbstractEffect
{
	@Override
	public String getSpellDisplayName() 
	{
		return "Summon Wolf";
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
