package spellbound.effects;

import spellbound.enums.EnumSpellType;

public class EffectLightningLvl2 extends AbstractEffect
{
	@Override
	public String getSpellDisplayName() 
	{
		return "Lightning Bolt";
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
