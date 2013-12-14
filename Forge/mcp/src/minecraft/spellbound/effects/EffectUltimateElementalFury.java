package spellbound.effects;

import java.util.List;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import spellbound.entity.EntityTargetSpell;
import spellbound.enums.EnumSpellType;

public class EffectUltimateElementalFury extends AbstractEffect 
{
	@Override
	public String getSpellDisplayName() 
	{
		return "Elemental Fury";
	}

	@Override
	public void doSpellEffect(EntityPlayer caster) 
	{
		caster.worldObj.playSoundAtEntity(caster, "mob.wither.spawn", 1.0F, 1.0F);
		caster.worldObj.playSoundAtEntity(caster, "ambient.weather.thunder", 1.0F, 1.0F);

		Vec3 vec = caster.getLookVec();
		EntityTargetSpell spell = new EntityTargetSpell(caster.worldObj, this);
		spell.setPosition(caster.posX + vec.xCoord * 5, caster.posY + 1 + vec.yCoord * 5, caster.posZ + vec.zCoord * 5);

		spell.accelerationX = vec.xCoord * 0.3;
		spell.accelerationY = vec.yCoord * 0.3;
		spell.accelerationZ = vec.zCoord * 0.3;

		if (!caster.worldObj.isRemote)
		{
			caster.worldObj.spawnEntityInWorld(spell);
		}
	}

	@Override
	public void updateSpellEffect() {
		// TODO Auto-generated method stub

	}

	@Override
	public EnumSpellType getSpellType() 
	{
		return EnumSpellType.FRONT;
	}

	@Override
	public void doSpellTargetEffect(World worldObj, int posX, int posY, int posZ, EntityLivingBase entityHit) 
	{
		int radius = 3;

		List entitiesList = entityHit == null ? 
				worldObj.getEntitiesWithinAABB(EntityLivingBase.class, AxisAlignedBB.getBoundingBox(posX - radius, posY - radius, posZ - radius, posX + radius, posY + radius, posZ + radius)) : 
					worldObj.getEntitiesWithinAABBExcludingEntity(entityHit, AxisAlignedBB.getBoundingBox(entityHit.posX - radius, entityHit.posY - radius, entityHit.posZ - radius, entityHit.posX + radius, entityHit.posY + radius, entityHit.posZ + radius));

				for (Object obj : entitiesList)
				{
					EntityLivingBase livingEntity = (EntityLivingBase)obj;
				}
	}
}
