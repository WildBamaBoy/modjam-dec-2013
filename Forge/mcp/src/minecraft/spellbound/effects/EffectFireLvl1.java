package spellbound.effects;

import spellbound.enums.EnumSpellType;

public class EffectFireLvl1 extends AbstractEffect
{
	@Override
	public String getSpellDisplayName() 
	{
		return "Flaming Hands";
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
