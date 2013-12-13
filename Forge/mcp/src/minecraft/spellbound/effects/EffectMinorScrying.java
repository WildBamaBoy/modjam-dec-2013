package spellbound.effects;

import spellbound.enums.EnumSpellType;

public class EffectMinorScrying extends AbstractEffect
{
	@Override
	public String getSpellDisplayName() 
	{
		return "Minor Scrying";
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
