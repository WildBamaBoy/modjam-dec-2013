package spellbound.spells;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.world.World;
import spellbound.entity.EntityTargetSpell;
import spellbound.enums.EnumItemInUseTime;
import spellbound.enums.EnumSpellType;

public class SpellTransport extends AbstractSpell
{
	@Override
	public String getSpellDisplayName() 
	{
		return "Transport";
	}

	@Override
	public void doSpellCasterEffect(EntityPlayer caster) 
	{
		this.caster = caster;

		if (!caster.worldObj.isRemote)
		{
			caster.inventory.consumeInventoryItem(caster.inventory.currentItem);
			caster.worldObj.playSoundAtEntity(caster, "mob.ghast.fireball", 1.0F, 1.0F);

			caster.worldObj.spawnEntityInWorld(new EntityTargetSpell(caster, this));
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
		if (!worldObj.isRemote && entityHit == null)
		{
			try
			{
				EntityPlayerMP casterMP = (EntityPlayerMP)caster;
				casterMP.mountEntity((Entity)null);
				casterMP.playerNetServerHandler.setPlayerLocation(posX, posY, posZ, caster.rotationYaw, caster.rotationPitch);
				caster.worldObj.playSoundAtEntity(casterMP, "mob.endermen.portal", 1.0F, 1.0F);
			}

			catch (ClassCastException e)
			{
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public EnumItemInUseTime getSpellDuration() 
	{
		return EnumItemInUseTime.TWO_SECONDS;
	}
}
