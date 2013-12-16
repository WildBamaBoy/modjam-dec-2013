package spellbound.spells;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import spellbound.core.SpellboundCore;
import spellbound.enums.EnumItemInUseTime;
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
		
		SpellboundCore.instance.addActiveSpellToPlayer(caster, this, 400);
	}
	
	@Override
	public EnumSpellType getSpellType() 
	{
		return EnumSpellType.SELF;
	}

	@Override
	public void doSpellTargetEffect(World worldObj, int posX, int posY, int posZ, EntityLivingBase entityHit) 
	{
	}
	
	@Override
	public EnumItemInUseTime getSpellCastDuration() 
	{
		return EnumItemInUseTime.FOUR_SECONDS;
	}
}
