package spellbound.effects;

import spellbound.enums.EnumSpellType;

public class EffectLightningLvl1 extends AbstractEffect
{
	@Override
	public String getSpellDisplayName() 
	{
		return "Tazer";
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
