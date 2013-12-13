package spellbound.effects;

import spellbound.enums.EnumSpellType;

public class EffectLightningLvl3 extends AbstractEffect
{
	@Override
	public String getSpellDisplayName() 
	{
		return "Summon Storm";
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
