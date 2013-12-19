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

import net.minecraft.entity.player.EntityPlayer;
import spellbound.core.SpellboundCore;
import spellbound.core.util.SpellEntry;
import spellbound.spells.SpellFireShield;
import spellbound.spells.SpellFlight;
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
		final Map<EntityPlayer, Integer> oldEntries = new HashMap<EntityPlayer, Integer>();
		
		for (final Map.Entry<EntityPlayer,List<SpellEntry>> entrySet : SpellboundCore.getInstance().getActiveSpells().entrySet())
		{
			final EntityPlayer player = entrySet.getKey();
			final List<SpellEntry> entryList = entrySet.getValue();
			
			for (SpellEntry entry : entryList)
			{
				entry.durationCounter++;
				
				if (entry.durationCounter == entry.maxDuration / 2)
				{
					player.addChatMessage(entry.spell.getSpellDisplayName() + " will dispel in " + entry.durationCounter / 20 + " seconds!");
				}
				
				if (entry.durationCounter >= entry.maxDuration)
				{
					oldEntries.put(player, entryList.indexOf(entry));
					player.addChatMessage(entry.spell.getSpellDisplayName() + " has dispelled!");
				}
				
				if (entry.spell instanceof SpellFireShield || entry.spell instanceof SpellShieldOfInvulnerability)
				{
					player.extinguish();
				}
			}
		}
		
		//Clean up old entries.
		for (final Map.Entry<EntityPlayer, Integer> oldEntry : oldEntries.entrySet())
		{
			final List<SpellEntry> activeSpells = SpellboundCore.getInstance().getActiveSpells().get(oldEntry.getKey());
			final EntityPlayer entryPlayer = oldEntry.getKey();
			final SpellEntry entry = activeSpells.get(oldEntry.getValue());

			activeSpells.remove(entry);
			
			if (entry.spell instanceof SpellFlight)
			{
				entryPlayer.capabilities.allowFlying = false;
				entryPlayer.capabilities.isFlying = false;
				PacketDispatcher.sendPacketToPlayer(PacketHandler.createFlightPacket(false), (Player) entryPlayer);
			}
		}
	}
}
