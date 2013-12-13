package spellbound.effects;

import spellbound.enums.EnumSpellType;

public class EffectColorSpray extends AbstractEffect
{
	@Override
	public String getSpellDisplayName() 
	{
		return "Color Spray";
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
