package spellbound.effects;

import spellbound.enums.EnumSpellType;

public class EffectDimensionDoor extends AbstractEffect
{
	@Override
	public String getSpellDisplayName() 
	{
		return "Dimension Door";
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
