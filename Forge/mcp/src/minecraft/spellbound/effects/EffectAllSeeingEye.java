package spellbound.effects;

import spellbound.enums.EnumSpellType;

public class EffectAllSeeingEye extends AbstractEffect
{
	@Override
	public String getSpellDisplayName() 
	{
		return "All Seeing Eye";
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
