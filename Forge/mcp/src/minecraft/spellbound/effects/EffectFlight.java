package spellbound.effects;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import spellbound.enums.EnumSpellType;

public class EffectFlight extends AbstractEffect
{
	@Override
	public String getSpellDisplayName() 
	{
		return "Flight";
	}

	@Override
	public void doSpellEffect(EntityPlayer caster) 
	{
		caster.capabilities.allowFlying = true;
		caster.fallDistance = 0;
		caster.motionY += 1.0D;
		caster.capabilities.isFlying = true;
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

	@Override
	public void doSpellTargetEffect(World worldObj, int posX, int posY, int posZ) {
		// TODO Auto-generated method stub
		
	}
}
