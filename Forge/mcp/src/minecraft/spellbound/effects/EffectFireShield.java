package spellbound.effects;

import spellbound.enums.EnumSpellType;

public class EffectFireShield extends AbstractEffect
{
	@Override
	public String getSpellDisplayName() 
	{
		return "Fire Shield";
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
