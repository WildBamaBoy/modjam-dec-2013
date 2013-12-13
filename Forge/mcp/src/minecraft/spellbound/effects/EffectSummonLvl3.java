package spellbound.effects;

import spellbound.enums.EnumSpellType;

public class EffectSummonLvl3 extends AbstractEffect
{
	@Override
	public String getSpellDisplayName() 
	{
		return "Summon Invisible Warrior";
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
