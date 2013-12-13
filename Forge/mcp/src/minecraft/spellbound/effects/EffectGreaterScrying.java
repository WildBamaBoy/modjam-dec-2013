package spellbound.effects;

import spellbound.enums.EnumSpellType;

public class EffectGreaterScrying extends AbstractEffect
{
	@Override
	public String getSpellDisplayName() 
	{
		return "Greater Scrying";
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
