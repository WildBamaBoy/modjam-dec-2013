package spellbound.effects;

import spellbound.enums.EnumSpellType;

public class EffectFishForm extends AbstractEffect
{
	@Override
	public String getSpellDisplayName() 
	{
		return "Fish Form";
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
