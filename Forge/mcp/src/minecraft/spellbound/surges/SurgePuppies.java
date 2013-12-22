/**********************************************
 * SurgePuppies.java
 * Copyright (c) 2013 Wild Bama Boy.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl.html
 **********************************************/

package spellbound.surges;

import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.entity.player.EntityPlayer;
import spellbound.core.SpellboundCore;
import spellbound.core.forge.PacketHandler;
import cpw.mods.fml.common.network.PacketDispatcher;

public class SurgePuppies extends AbstractSurge
{
	@Override
	public String getSpellDisplayName() 
	{
		return "Puppies!";
	}

	@Override
	public void doSpellCasterEffect(EntityPlayer caster) 
	{
		caster.worldObj.playSoundAtEntity(caster, "spellbound:surge", 1.0F, 1.0F);
		
		for (int i = 0; i < SpellboundCore.modRandom.nextInt(5) + 2; i++)
		{
			final EntityWolf wolf = new EntityWolf(caster.worldObj);
			wolf.setPosition(caster.posX, caster.posY, caster.posZ);
			wolf.setGrowingAge(-24000);
			caster.worldObj.spawnEntityInWorld(wolf);

			PacketDispatcher.sendPacketToAllPlayers(PacketHandler.createSummonGFXPacket(wolf.posX, wolf.posY, wolf.posZ));
		}
	}
}
