package spellbound.effects;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import spellbound.entity.EntityTargetSpell;
import spellbound.enums.EnumSpellType;

public class EffectTransport extends AbstractEffect
{
	@Override
	public String getSpellDisplayName() 
	{
		return "Transport";
	}

	@Override
	public void doSpellEffect(EntityPlayer caster) 
	{
		this.caster = caster;

		if (!caster.worldObj.isRemote)
		{
			caster.inventory.consumeInventoryItem(caster.inventory.currentItem);
			caster.worldObj.playSoundAtEntity(caster, "mob.ghast.fireball", 1.0F, 1.0F);

			Vec3 vec = caster.getLookVec();
			EntityTargetSpell spell = new EntityTargetSpell(caster.worldObj, this);
			spell.setPosition(caster.posX + vec.xCoord * 5, caster.posY + vec.yCoord * 5, caster.posZ + vec.zCoord * 5);

			spell.accelerationX = vec.xCoord * 0.3;
			spell.accelerationY = vec.yCoord * 0.3;
			spell.accelerationZ = vec.zCoord * 0.3;

			caster.worldObj.spawnEntityInWorld(spell);
		}
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
}
