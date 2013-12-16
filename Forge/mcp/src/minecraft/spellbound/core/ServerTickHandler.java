package spellbound.core;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.minecraft.entity.player.EntityPlayer;
import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.TickType;

public class ServerTickHandler implements ITickHandler
{
	@Override
	public void tickStart (EnumSet<TickType> type, Object... tickData)
	{

	}

	@Override
	public void tickEnd(EnumSet<TickType> type, Object... tickData)
	{
		System.out.println("AA");
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
		Map<EntityPlayer, Integer> oldEntries = new HashMap<EntityPlayer, Integer>();
		
		for (Map.Entry<EntityPlayer,List<SpellEntry>> entrySet : SpellboundCore.activeSpells.entrySet())
		{
			EntityPlayer player = entrySet.getKey();
			List<SpellEntry> entryList = entrySet.getValue();
			
			for (SpellEntry entry : entryList)
			{	
				entry.durationCounter++;
				
				if (entry.durationCounter == (entry.maxDuration / 2))
				{
					player.addChatMessage(entry.spell.getSpellDisplayName() + " will dispel in " + entry.durationCounter / 20 + " seconds!");
				}
				
				if (entry.durationCounter >= entry.maxDuration)
				{
					oldEntries.put(player, entryList.indexOf(entry));
					player.addChatMessage(entry.spell.getSpellDisplayName() + " has dispelled!");
				}
			}
		}
		
		//Clean up old entries.
		for (Map.Entry<EntityPlayer, Integer> oldEntry : oldEntries.entrySet())
		{
			List<SpellEntry> Spells = SpellboundCore.activeSpells.get(oldEntry.getKey());
			Spells.remove(Spells.get(oldEntry.getValue()));
		}
	}
}
