/**********************************************
 * SpellLightningLvl2.java
 * Copyright (c) 2013 Wild Bama Boy.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl.html
 **********************************************/

package spellbound.spells;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import spellbound.core.SpellboundCore;
import spellbound.core.forge.PacketHandler;
import spellbound.entity.EntityTargetSpellLightning;
import spellbound.enums.EnumItemInUseTime;
import spellbound.enums.EnumSpellRange;
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
	public EnumSpellRange getSpellType() 
	{
		return EnumSpellRange.TARGET;
	}

	@Override
	public void doSpellTargetEffect(World worldObj, int posX, int posY, int posZ, EntityLivingBase entityHit) 
	{
		final double spawnX = entityHit == null ? posX : entityHit.posX;
		final double spawnY = entityHit == null ? posY : entityHit.posY;
		final double spawnZ = entityHit == null ? posZ : entityHit.posZ;

		if (entityHit instanceof EntityPlayer)
		{
			if (!SpellboundCore.getInstance().playerHasActiveSpell((EntityPlayer)entityHit, SpellShieldOfInvulnerability.class) && !SpellboundCore.getInstance().playerHasActiveSpell((EntityPlayer)entityHit, SpellLightningShield.class))
			{
				worldObj.spawnEntityInWorld(new EntityLightningBolt(worldObj, spawnX, spawnY, spawnZ));
				PacketDispatcher.sendPacketToAllPlayers(PacketHandler.createLightningPacket(spawnX, spawnY, spawnZ));
			}
		}

		else
		{
			worldObj.spawnEntityInWorld(new EntityLightningBolt(worldObj, spawnX, spawnY, spawnZ));
			PacketDispatcher.sendPacketToAllPlayers(PacketHandler.createLightningPacket(spawnX, spawnY, spawnZ));
		}
	}

	@Override
	public EnumItemInUseTime getSpellCastDuration() 
	{
		return EnumItemInUseTime.TWO_SECONDS;
	}
}
