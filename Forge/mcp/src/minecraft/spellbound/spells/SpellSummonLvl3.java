/**********************************************
 * SpellSummonLvl3.java
 * Copyright (c) 2013 Wild Bama Boy.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl.html
 **********************************************/

package spellbound.spells;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import spellbound.core.forge.PacketHandler;
import spellbound.enums.EnumItemInUseTime;
import spellbound.enums.EnumSpellRange;
import cpw.mods.fml.common.network.PacketDispatcher;

public class SpellSummonLvl3 extends AbstractSpell
{
	@Override
	public String getSpellDisplayName() 
	{
		return "Summon Wither Skeleton";
	}

	@Override
	public void doSpellCasterEffect(EntityPlayer caster) 
	{
		caster.worldObj.playSoundAtEntity(caster, "mob.wither.idle", 1.0F, 1.0F);

		final EntitySkeleton witherSkeleton = new EntitySkeleton(caster.worldObj);
		witherSkeleton.setSkeletonType(1);
		witherSkeleton.setPosition(caster.posX, caster.posY, caster.posZ);

		caster.worldObj.spawnEntityInWorld(witherSkeleton);
		PacketDispatcher.sendPacketToAllPlayers(PacketHandler.createSummonGFXPacket(witherSkeleton.posX, witherSkeleton.posY, witherSkeleton.posZ));
	}

	@Override
	public EnumSpellRange getSpellType() 
	{
		return EnumSpellRange.SELF;
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
