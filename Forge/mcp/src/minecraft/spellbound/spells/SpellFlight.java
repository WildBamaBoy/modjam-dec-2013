package spellbound.spells;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import spellbound.enums.EnumSpellType;

public class SpellFlight extends AbstractSpell
{
	@Override
	public String getSpellDisplayName() 
	{
		return "Flight";
	}

	@Override
	public void doSpellCasterEffect(EntityPlayer caster) 
	{
		caster.capabilities.allowFlying = true;
		caster.fallDistance = 0;
		caster.motionY += 1.0D;
		caster.capabilities.isFlying = true;
	}
	
	@Override
	public EnumSpellType getSpellType() 
	{
		return EnumSpellType.SELF;
	}

	@Override
	public void doSpellTargetEffect(World worldObj, int posX, int posY, int posZ, EntityLivingBase entityHit) {
		// TODO Auto-generated method stub
		
	}
}
