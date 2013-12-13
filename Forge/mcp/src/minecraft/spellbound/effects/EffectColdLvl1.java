package spellbound.effects;

import spellbound.enums.EnumSpellType;

public class EffectColdLvl1 extends AbstractEffect
{
	@Override
	public String getSpellDisplayName() 
	{
		return "Icy Grip";
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
