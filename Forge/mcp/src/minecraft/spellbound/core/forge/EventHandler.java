/**********************************************
 * EventHandler.java
 * Copyright (c) 2013 Wild Bama Boy.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl.html
 **********************************************/

package spellbound.core.forge;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.client.event.sound.SoundLoadEvent;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import spellbound.core.SpellboundCore;
import spellbound.spells.SpellShieldOfInvulnerability;

public class EventHandler 
{
	@ForgeSubscribe
	public void onSound(SoundLoadEvent event)
	{
		event.manager.soundPoolSounds.addSound("spellbound:banshee.ogg");
		event.manager.soundPoolSounds.addSound("spellbound:spellcharge1second.ogg");
		event.manager.soundPoolSounds.addSound("spellbound:spellcharge2seconds.ogg");
		event.manager.soundPoolSounds.addSound("spellbound:spellcharge3seconds.ogg");
		event.manager.soundPoolSounds.addSound("spellbound:spellcharge4seconds.ogg");
		event.manager.soundPoolSounds.addSound("spellbound:spellcharge5seconds.ogg");
		event.manager.soundPoolSounds.addSound("spellbound:shield.ogg");
		event.manager.soundPoolSounds.addSound("spellbound:surge.ogg");
		event.manager.soundPoolSounds.addSound("spellbound:meteor.ogg");
	}
	
	@ForgeSubscribe
	public void onLivingHurt(LivingHurtEvent event)
	{
		if (event.entityLiving instanceof EntityPlayer && !event.source.isUnblockable() && !event.source.isProjectile() && !event.source.damageType.equals("player") &&
				SpellboundCore.getInstance().entityHasActiveSpell(event.entityLiving, SpellShieldOfInvulnerability.class))
		{
			event.setCanceled(true);
			event.ammount = 0.0F;
		}
	}
}
