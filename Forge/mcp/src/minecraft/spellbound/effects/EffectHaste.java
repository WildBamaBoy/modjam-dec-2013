package spellbound.effects;

import net.minecraft.entity.player.EntityPlayer;
import spellbound.enums.EnumSpellType;

public class EffectHaste extends AbstractEffect
{
	@Override
	public String getSpellDisplayName() 
	{
		return "Haste";
	}

	@Override
	public void doSpellEffect(EntityPlayer caster) 
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