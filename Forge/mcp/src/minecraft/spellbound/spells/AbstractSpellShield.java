/**********************************************
 * AbstractSpellShield.java
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
import spellbound.enums.EnumSpellRange;
import cpw.mods.fml.common.network.PacketDispatcher;

public abstract class AbstractSpellShield extends AbstractSpell
{
	@Override
	public final void doSpellCasterEffect(EntityPlayer caster) 
	{
		this.caster = caster;

		if (this instanceof SpellShieldOfInvulnerability)
		{
			caster.worldObj.playSoundAtEntity(caster, "mob.wither.idle", 1.0F, 1.0F);
		}

		else
		{
			caster.worldObj.playSoundAtEntity(caster, "spellbound:shield", 1.0F, 1.0F);
		}
		
		SpellboundCore.getInstance().addActiveSpellToEntity(caster, this, getShieldDuration());
		PacketDispatcher.sendPacketToAllPlayers(PacketHandler.createShieldGFXPacket(this.getClass(), caster.posX, caster.posY, caster.posZ));
	}

	@Override
	public final void doSpellTargetEffect(World worldObj, int posX, int posY, int posZ, EntityLivingBase entityHit) 
	{
		//No target effect.
	}

	@Override
	public final EnumSpellRange getSpellType() 
	{
		return EnumSpellRange.SELF;
	}

	public abstract int getShieldDuration();
}
