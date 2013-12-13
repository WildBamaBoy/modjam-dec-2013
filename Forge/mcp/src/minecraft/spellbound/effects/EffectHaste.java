package spellbound.effects;

import spellbound.enums.EnumSpellType;

public class EffectHaste extends AbstractEffect
{
	@Override
	public String getSpellDisplayName() 
	{
		return "Haste";
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
