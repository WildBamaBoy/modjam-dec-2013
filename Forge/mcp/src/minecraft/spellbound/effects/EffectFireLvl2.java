package spellbound.effects;

import spellbound.enums.EnumSpellType;

public class EffectFireLvl2 extends AbstractEffect
{
	@Override
	public String getSpellDisplayName() 
	{
		return "Fireball";
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
		return EnumSpellType.TARGET;
	}
}
