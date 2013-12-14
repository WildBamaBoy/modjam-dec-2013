package spellbound.effects;

import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import spellbound.core.SB;
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
		if (!worldObj.isRemote)
		{
		int radius = 8;

		List entitiesList = entityHit == null ? 
				worldObj.getEntitiesWithinAABB(Entity.class, AxisAlignedBB.getBoundingBox(posX - radius, posY - radius, posZ - radius, posX + radius, posY + radius, posZ + radius)) : 
					worldObj.getEntitiesWithinAABB(Entity.class, AxisAlignedBB.getBoundingBox(entityHit.posX - radius, entityHit.posY - radius, entityHit.posZ - radius, entityHit.posX + radius, entityHit.posY + radius, entityHit.posZ + radius));

				for (Object obj : entitiesList)
				{
					if (obj instanceof EntityLivingBase)
					{
						EntityLivingBase livingEntity = (EntityLivingBase)obj;
						
						if (SB.rand.nextBoolean())
						{
							//Cold
							livingEntity.attackEntityFrom(DamageSource.magic, 15.0F);
							livingEntity.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 1200));
						}
						
						else if (SB.rand.nextBoolean())
						{
							livingEntity.attackEntityFrom(DamageSource.magic, 10.0F);
							livingEntity.setFire(15);
							worldObj.createExplosion(livingEntity, livingEntity.posX, livingEntity.posY, livingEntity.posZ, 5.0F, false);
						}
						
						else
						{
							livingEntity.attackEntityFrom(DamageSource.magic, 15.0F);
							EntityLightningBolt lightning = new EntityLightningBolt(worldObj, posX, posY, posZ);
							lightning.setPosition(posX, posY, posZ);
							worldObj.spawnEntityInWorld(lightning);
						}
					}
				}
		}
	}
}
