package spellbound.effects;

import spellbound.enums.EnumSpellType;

public class EffectGrease extends AbstractEffect
{
	@Override
	public String getSpellDisplayName() 
	{
		return "Grease";
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
