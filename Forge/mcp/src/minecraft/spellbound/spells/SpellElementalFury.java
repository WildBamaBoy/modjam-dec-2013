package spellbound.spells;

import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import spellbound.core.PacketHandler;
import spellbound.core.SpellboundCore;
import spellbound.entity.EntityTargetSpell;
import spellbound.enums.EnumSpellType;
import cpw.mods.fml.common.network.PacketDispatcher;

public class SpellElementalFury extends AbstractSpell 
{
	@Override
	public String getSpellDisplayName() 
	{
		return "Elemental Fury";
	}

	@Override
	public void doSpellCasterEffect(EntityPlayer caster) 
	{
		caster.worldObj.playSoundAtEntity(caster, "mob.wither.spawn", 1.0F, 1.0F);
		caster.worldObj.playSoundAtEntity(caster, "ambient.weather.thunder", 1.0F, 1.0F);

		if (!caster.worldObj.isRemote)
		{
			final EntityTargetSpell spell = new EntityTargetSpell(caster, this);
			caster.worldObj.spawnEntityInWorld(spell);
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

							if (SpellboundCore.rand.nextBoolean())
							{
								livingEntity.attackEntityFrom(DamageSource.magic, 15.0F);
								livingEntity.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 1200));
							}

							else if (SpellboundCore.rand.nextBoolean())
							{
								livingEntity.attackEntityFrom(DamageSource.magic, 10.0F);
								livingEntity.setFire(15);
								worldObj.createExplosion(livingEntity, livingEntity.posX, livingEntity.posY, livingEntity.posZ, 5.0F, false);
							}

							else
							{
								livingEntity.attackEntityFrom(DamageSource.magic, 15.0F);

								double spawnX = entityHit != null ? entityHit.posX : posX;
								double spawnY = entityHit != null ? entityHit.posY : posY;
								double spawnZ = entityHit != null ? entityHit.posZ : posZ;

								EntityLightningBolt lightning = new EntityLightningBolt(worldObj, spawnX, spawnY, spawnZ);
								worldObj.spawnEntityInWorld(lightning);

								PacketDispatcher.sendPacketToAllPlayers(PacketHandler.createLightningPacket(spawnX, spawnY, spawnZ));
							}
						}
					}
		}
	}
}
