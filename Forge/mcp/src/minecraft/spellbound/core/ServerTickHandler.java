package spellbound.core;

import java.util.EnumSet;
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
		for (Map.Entry<EntityPlayer,List<EffectEntry>> entrySet : SB.activeSpellEffects.entrySet())
		{
			EntityPlayer player = entrySet.getKey();
			List<EffectEntry> entryList = entrySet.getValue();
			
			for (EffectEntry entry : entryList)
			{
				entry.durationCounter--;
				
				System.out.println(entry.durationCounter);
				
				if (entry.durationCounter == (entry.durationCounter / 2))
				{
					player.addChatMessage(entry.effect.getSpellDisplayName() + " will dispel in " + entry.durationCounter / 20 + " seconds!");
				}
				
				if (entry.durationCounter <= 0)
				{
					player.addChatMessage(entry.effect.getSpellDisplayName() + " has dispelled!");
				}
			}
		}
	}
}
