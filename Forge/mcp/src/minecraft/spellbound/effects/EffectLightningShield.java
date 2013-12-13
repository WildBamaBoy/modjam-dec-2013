package spellbound.effects;

import spellbound.enums.EnumSpellType;

public class EffectLightningShield extends AbstractEffect
{
	@Override
	public String getSpellDisplayName() 
	{
		return "Lighting Shield";
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
