/**********************************************
 * SpellFlight.java
 * Copyright (c) 2013 Wild Bama Boy.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl.html
 **********************************************/

package spellbound.spells;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import spellbound.core.SpellboundCore;
import spellbound.core.forge.PacketHandler;
import spellbound.enums.EnumItemInUseTime;
import spellbound.enums.EnumSpellRange;
import cpw.mods.fml.common.network.PacketDispatcher;
import cpw.mods.fml.common.network.Player;

public class SpellFlightLvl2 extends AbstractSpell
{
	@Override
	public String getSpellDisplayName() 
	{
		return "Flight";
	}

	@Override
	public void doSpellCasterEffect(EntityPlayer caster) 
	{
		caster.worldObj.playSoundAtEntity(caster, "mob.enderdragon.wings", 1.0F, 1.0F);
		
		if (caster.onGround)
		{
			caster.motionY += 1.0D;
		}
		
		caster.fallDistance = 0;
		caster.capabilities.allowFlying = true;
		caster.capabilities.isFlying = true;
		
		SpellboundCore.getInstance().addActiveSpellToEntity(caster, this, 400);
		PacketDispatcher.sendPacketToPlayer(PacketHandler.createFlightPacket(true), (Player) caster);
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
		return EnumItemInUseTime.FOUR_SECONDS;
	}
}
