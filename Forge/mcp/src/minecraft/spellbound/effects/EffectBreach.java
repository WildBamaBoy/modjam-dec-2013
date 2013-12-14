package spellbound.effects;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import spellbound.enums.EnumSpellType;

public class EffectBreach extends AbstractEffect
{
	@Override
	public String getSpellDisplayName() 
	{
		return "Breach";
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
		return EnumSpellType.TARGET;
	}

	@Override
	public void doSpellTargetEffect(World worldObj, int posX, int posY, int posZ) 
	{

	}
}
