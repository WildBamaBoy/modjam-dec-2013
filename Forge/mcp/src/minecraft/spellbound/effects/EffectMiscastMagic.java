package spellbound.effects;

import spellbound.enums.EnumSpellType;

public class EffectMiscastMagic extends AbstractEffect
{
	@Override
	public String getSpellDisplayName() 
	{
		return "Miscast Magic";
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
