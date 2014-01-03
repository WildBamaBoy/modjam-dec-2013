/**********************************************
 * SpellColdLvl2.java
 * Copyright (c) 2013 Wild Bama Boy.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl.html
 **********************************************/

package spellbound.spells;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import spellbound.core.Constants;
import spellbound.core.SpellboundCore;
import spellbound.core.forge.PacketHandler;
import spellbound.core.util.Logic;
import spellbound.core.util.Point3D;
import spellbound.entity.EntityTargetSpellCold;
import spellbound.enums.EnumItemInUseTime;
import spellbound.enums.EnumSpellRange;
import cpw.mods.fml.common.network.PacketDispatcher;

public class SpellColdLvl2 extends AbstractSpell
{
	@Override
	public String getSpellDisplayName() 
	{
		return "Icicle";
	}

	@Override
	public void doSpellCasterEffect(EntityPlayer caster) 
	{
		caster.worldObj.playSoundAtEntity(caster, "mob.ghast.fireball", 1.0F, 1.0F);
		caster.worldObj.spawnEntityInWorld(new EntityTargetSpellCold(caster, this));
	}

	@Override
	public EnumSpellRange getSpellType() 
	{
		return EnumSpellRange.TARGET;
	}

	@Override
	public void doSpellTargetEffect(World worldObj, int posX, int posY, int posZ, EntityLivingBase entityHit) 
	{
		if (entityHit != null)
		{
			PacketDispatcher.sendPacketToAllPlayers(PacketHandler.createColdGFXPacket(2, 0, entityHit.posX, entityHit.posY, entityHit.posZ));
			
			for (final Point3D point : Logic.getNearbyBlocks(worldObj, (int)entityHit.posX, (int)entityHit.posY, (int)entityHit.posZ, 3, Constants.SNOW_SUPPORTERS))
			{
				if (worldObj.getBlockId(point.posX, point.posY + 1, point.posZ) == 0)
				{
					worldObj.setBlock(point.posX, point.posY + 1, point.posZ, Block.snow.blockID);
				}
			}

			if (entityHit instanceof EntityPlayer)
			{
				if (!SpellboundCore.getInstance().entityHasActiveSpell((EntityPlayer)entityHit, SpellShieldOfInvulnerability.class) && !SpellboundCore.getInstance().entityHasActiveSpell((EntityPlayer)entityHit, SpellColdShield.class))
				{							
					entityHit.attackEntityFrom(DamageSource.magic, 5.0F);
					entityHit.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 1200));
					entityHit.extinguish();
				}
			}

			else
			{
				entityHit.attackEntityFrom(DamageSource.magic, 5.0F);
				entityHit.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 1200));
				entityHit.extinguish();
			}
		}
	}

	@Override
	public EnumItemInUseTime getSpellCastDuration() 
	{
		return EnumItemInUseTime.TWO_SECONDS;
	}
}
