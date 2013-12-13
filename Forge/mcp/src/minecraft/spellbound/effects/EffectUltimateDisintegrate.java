package spellbound.effects;

import spellbound.enums.EnumSpellType;

public class EffectUltimateDisintegrate extends AbstractEffect
{
	@Override
	public String getSpellDisplayName()
	{
		return "Disintegrate";
	}

	@Override
	public void doSpellEffect() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateSpellEffect() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public EnumSpellType getSpellType() 
	{
		return EnumSpellType.TARGET;
	}
}
