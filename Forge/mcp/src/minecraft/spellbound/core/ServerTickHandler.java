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
		return "Spellbound Ticks";
	}
	
	private void onTick()
	{
		Map<EntityPlayer, Integer> oldEntries = new HashMap<EntityPlayer, Integer>();
		
		for (Map.Entry<EntityPlayer,List<EffectEntry>> entrySet : SB.activeSpellEffects.entrySet())
		{
			EntityPlayer player = entrySet.getKey();
			List<EffectEntry> entryList = entrySet.getValue();
			
			for (EffectEntry entry : entryList)
			{
				System.out.println("ENTRY!");
				entry.durationCounter++;
				
				if (entry.durationCounter == (entry.maxDuration / 2))
				{
					player.addChatMessage(entry.effect.getSpellDisplayName() + " will dispel in " + entry.durationCounter / 20 + " seconds!");
				}
				
				if (entry.durationCounter >= entry.maxDuration)
				{
					oldEntries.put(player, entryList.indexOf(entry));
				}
				System.out.println("ENTRY END");
			}
		}
		
		//Clean up old entries.
		for (Map.Entry<EntityPlayer, Integer> oldEntry : oldEntries.entrySet())
		{
			List<EffectEntry> effects = SB.activeSpellEffects.get(oldEntry.getKey());
			effects.remove(effects.get(oldEntry.getValue()));

			System.out.println("A");//oldEntry.getKey().addChatMessage(oldEntry.effect.getSpellDisplayName() + " has dispelled!");
		}
	}
}
