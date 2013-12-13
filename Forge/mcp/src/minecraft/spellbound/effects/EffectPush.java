package spellbound.effects;

import spellbound.enums.EnumSpellType;

public class EffectPush extends AbstractEffect
{
	@Override
	public String getSpellDisplayName() 
	{
		return "Push";
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
		return EnumSpellType.AREA;
	}
}
