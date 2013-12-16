package spellbound.spells;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import spellbound.core.PacketHandler;
import spellbound.core.SpellboundCore;
import spellbound.entity.EntityTargetSpellLightning;
import spellbound.enums.EnumItemInUseTime;
import spellbound.enums.EnumSpellType;
import cpw.mods.fml.common.network.PacketDispatcher;

public class SpellLightningLvl2 extends AbstractSpell
{
	@Override
	public String getSpellDisplayName() 
	{
		return "Lightning Bolt";
	}

	@Override
	public void doSpellCasterEffect(EntityPlayer caster) 
	{
		if (!caster.worldObj.isRemote)
		{
			caster.worldObj.playSoundAtEntity(caster, "mob.ghast.fireball", 1.0F, 1.0F);
			caster.worldObj.spawnEntityInWorld(new EntityTargetSpellLightning(caster, this));
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
		double spawnX = entityHit != null ? entityHit.posX : posX;
		double spawnY = entityHit != null ? entityHit.posY : posY;
		double spawnZ = entityHit != null ? entityHit.posZ : posZ;

		if (entityHit != null && entityHit instanceof EntityPlayer)
		{
			if (!SpellboundCore.instance.playerHasActiveSpell((EntityPlayer)entityHit, "SpellShieldOfInvulnerability") && !SpellboundCore.instance.playerHasActiveSpell((EntityPlayer)entityHit, "SpellLightningShield"))
			{
				EntityLightningBolt lightning = new EntityLightningBolt(worldObj, spawnX, spawnY, spawnZ);
				worldObj.spawnEntityInWorld(lightning);

				PacketDispatcher.sendPacketToAllPlayers(PacketHandler.createLightningPacket(spawnX, spawnY, spawnZ));
			}
		}

		else
		{
			EntityLightningBolt lightning = new EntityLightningBolt(worldObj, spawnX, spawnY, spawnZ);
			worldObj.spawnEntityInWorld(lightning);

			PacketDispatcher.sendPacketToAllPlayers(PacketHandler.createLightningPacket(spawnX, spawnY, spawnZ));
		}
	}

	@Override
	public EnumItemInUseTime getSpellCastDuration() 
	{
		return EnumItemInUseTime.TWO_SECONDS;
	}
}
