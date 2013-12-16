package spellbound.spells;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;
import spellbound.core.PacketHandler;
import spellbound.core.SpellboundCore;
import spellbound.enums.EnumItemInUseTime;
import spellbound.enums.EnumSpellType;
import cpw.mods.fml.common.network.PacketDispatcher;

public class SpellLightningLvl3 extends AbstractSpell
{
	@Override
	public String getSpellDisplayName() 
	{
		return "Area Lightning";
	}

	@Override
	public void doSpellCasterEffect(EntityPlayer caster) 
	{
		caster.worldObj.playSoundEffect(caster.posX, caster.posY, caster.posZ, "ambient.weather.thunder", 10000.0F, 1.0F);

		if (!caster.worldObj.isRemote)
		{
			for (Object obj : caster.worldObj.getEntitiesWithinAABBExcludingEntity(caster, AxisAlignedBB.getBoundingBox(caster.posX - 35, caster.posY - 15, caster.posZ - 35, caster.posX + 35, caster.posY + 15, caster.posZ + 35)))
			{
				if (obj instanceof EntityLivingBase)
				{
					if (SpellboundCore.rand.nextBoolean() && SpellboundCore.rand.nextBoolean() && SpellboundCore.rand.nextBoolean() && SpellboundCore.rand.nextBoolean())
					{
						//Save
					}

					else
					{
						EntityLivingBase entity = (EntityLivingBase)obj;

						if (entity instanceof EntityPlayer)
						{
							if (!SpellboundCore.instance.playerHasActiveSpell((EntityPlayer)entity, "SpellShieldOfInvulnerability") && !SpellboundCore.instance.playerHasActiveSpell((EntityPlayer)entity, "SpellLightningShield"))
							{
								EntityLightningBolt lightning = new EntityLightningBolt(caster.worldObj, entity.posX, entity.posY, entity.posZ);
								caster.worldObj.spawnEntityInWorld(lightning);

								PacketDispatcher.sendPacketToAllPlayers(PacketHandler.createLightningPacket(entity.posX, entity.posY, entity.posZ));
							}
						}

						else
						{
							EntityLightningBolt lightning = new EntityLightningBolt(caster.worldObj, entity.posX, entity.posY, entity.posZ);
							caster.worldObj.spawnEntityInWorld(lightning);

							PacketDispatcher.sendPacketToAllPlayers(PacketHandler.createLightningPacket(entity.posX, entity.posY, entity.posZ));
						}
					}
				}
			}
		}
	}

	@Override
	public EnumSpellType getSpellType() 
	{
		return EnumSpellType.AREA;
	}

	@Override
	public void doSpellTargetEffect(World worldObj, int posX, int posY, int posZ, EntityLivingBase entityHit) 
	{
		//No target effect.
	}

	@Override
	public EnumItemInUseTime getSpellCastDuration() 
	{
		return EnumItemInUseTime.THREE_SECONDS;
	}
}
