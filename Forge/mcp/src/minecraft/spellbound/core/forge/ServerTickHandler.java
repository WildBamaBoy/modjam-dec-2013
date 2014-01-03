/**********************************************
 * ServerTickHandler.java
 * Copyright (c) 2013 Wild Bama Boy.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl.html
 **********************************************/

package spellbound.core.forge;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import spellbound.core.SpellboundCore;
import spellbound.core.util.SpellEntry;
import spellbound.spells.SpellColdLvl3;
import spellbound.spells.SpellFireShield;
import spellbound.spells.SpellFlightLvl1;
import spellbound.spells.SpellFlightLvl2;
import spellbound.spells.SpellShieldOfInvulnerability;
import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.TickType;
import cpw.mods.fml.common.network.PacketDispatcher;
import cpw.mods.fml.common.network.Player;

public class ServerTickHandler implements ITickHandler
{
	@Override
	public void tickStart (EnumSet<TickType> type, Object... tickData)
	{
		//Do on tickEnd.
	}

	@Override
	public void tickEnd(EnumSet<TickType> type, Object... tickData)
	{
		if (type.equals(EnumSet.of(TickType.SERVER)))
		{
			onTick();
		}
	}

	@Override
	public EnumSet<TickType> ticks()
	{
		return EnumSet.of(TickType.SERVER);
	}

	@Override
	public String getLabel()
	{
		return "Spellbound - ServerTickHandler";
	}

	private void onTick()
	{
		final Map<EntityLivingBase, Integer> oldEntries = new HashMap<EntityLivingBase, Integer>();

		for (final Map.Entry<EntityLivingBase,List<SpellEntry>> entrySet : SpellboundCore.getInstance().getActiveSpells().entrySet())
		{
			final EntityLivingBase entityLiving = entrySet.getKey();
			final List<SpellEntry> entryList = entrySet.getValue();

			for (SpellEntry entry : entryList)
			{
				entry.durationCounter++;

				if (entityLiving instanceof EntityPlayer && entry.durationCounter == entry.maxDuration / 2)
				{
					final EntityPlayer player = (EntityPlayer)entityLiving;
					player.addChatMessage(entry.spell.getSpellDisplayName() + " will dispel in " + entry.durationCounter / 20 + " seconds!");
				}

				if (entityLiving instanceof EntityPlayer && entry.durationCounter >= entry.maxDuration)
				{
					final EntityPlayer player = (EntityPlayer)entityLiving;
					oldEntries.put(player, entryList.indexOf(entry));
					player.addChatMessage(entry.spell.getSpellDisplayName() + " has dispelled!");
				}

				if (entry.spell instanceof SpellFireShield || entry.spell instanceof SpellShieldOfInvulnerability)
				{
					entityLiving.extinguish();
				}
				
				if (entry.spell instanceof SpellColdLvl3)
				{
					entityLiving.motionX = 0;
					entityLiving.motionY = 0;
					entityLiving.motionZ = 0;
				}
			}
		}

		//Clean up old entries.
		for (final Map.Entry<EntityLivingBase, Integer> oldEntry : oldEntries.entrySet())
		{
			final List<SpellEntry> activeSpells = SpellboundCore.getInstance().getActiveSpells().get(oldEntry.getKey());
			final EntityLivingBase entryEntity = oldEntry.getKey();
			final SpellEntry entry = activeSpells.get(oldEntry.getValue());

			activeSpells.remove(entry);

			if (entryEntity instanceof EntityPlayer && (entry.spell instanceof SpellFlightLvl1 || entry.spell instanceof SpellFlightLvl2))
			{
				final EntityPlayer entryPlayer = (EntityPlayer)entryEntity;
				if (!entryPlayer.capabilities.isCreativeMode)
				{
					entryPlayer.capabilities.allowFlying = false;
					entryPlayer.capabilities.isFlying = false;
					PacketDispatcher.sendPacketToPlayer(PacketHandler.createFlightPacket(false), (Player) entryPlayer);
				}
			}
		}
	}
}
