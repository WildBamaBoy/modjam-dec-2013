package spellbound.effects;

import spellbound.enums.EnumSpellType;

public class EffectAdvanceTime extends AbstractEffect
{
	@Override
	public String getSpellDisplayName() 
	{
		return "Advance Time";
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
