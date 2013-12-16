package spellbound.spells;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import spellbound.core.SpellboundCore;
import spellbound.entity.EntityTargetSpellFire;
import spellbound.enums.EnumItemInUseTime;
import spellbound.enums.EnumSpellType;

public class SpellFireLvl3 extends AbstractSpell
{
	@Override
	public String getSpellDisplayName() 
	{
		return "Greater Fireball";
	}

	@Override
	public void doSpellCasterEffect(EntityPlayer caster) 
	{
		if (!caster.worldObj.isRemote)
		{
			caster.worldObj.playSoundAtEntity(caster, "mob.ghast.fireball", 1.0F, 1.0F);
			caster.worldObj.spawnEntityInWorld(new EntityTargetSpellFire(caster, this));
		}
	}

	@Override
	public EnumSpellType getSpellType() 
	{
		return EnumSpellType.TARGET;
	}

	@Override
	public void doSpellTargetEffect(World worldObj, int posX, int posY, int posZ, EntityLivingBase entityHit) 
	{
		if (entityHit != null)
		{
			worldObj.createExplosion(entityHit, entityHit.posX, entityHit.posY, entityHit.posZ, 8.0F, true);
		}

		else
		{
			if (entityHit instanceof EntityPlayer)
			{
				if (!SpellboundCore.instance.playerHasActiveSpell((EntityPlayer)entityHit, "SpellShieldOfInvulnerability") && !SpellboundCore.instance.playerHasActiveSpell((EntityPlayer)entityHit, "SpellFireShield"))
				{							
					worldObj.createExplosion(null, (double)posX, (double)posY, (double)posZ, 8.0F, true);
				}
			}

			else
			{
				worldObj.createExplosion(null, (double)posX, (double)posY, (double)posZ, 8.0F, true);
			}
		}
	}

	@Override
	public EnumItemInUseTime getSpellCastDuration() 
	{
		return EnumItemInUseTime.THREE_SECONDS;
	}
}