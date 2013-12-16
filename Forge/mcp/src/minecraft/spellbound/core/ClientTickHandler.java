package spellbound.core;

import java.util.EnumSet;

import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.TickType;

public class ClientTickHandler implements ITickHandler
{
	@Override
	public void tickStart(EnumSet<TickType> type, Object... tickData) 
	{
	}

	@Override
	public void tickEnd(EnumSet<TickType> type, Object... tickData) 
	{
		if (SpellboundCore.keyNextEye.isPressed())
		{
			SpellboundCore.keyBindHandler.keyDown(type, SpellboundCore.keyNextEye, true, false);
		}
		
		else if (SpellboundCore.keyPreviousEye.isPressed())
		{
			SpellboundCore.keyBindHandler.keyDown(type, SpellboundCore.keyPreviousEye, true, false);
		}
		
		else if (SpellboundCore.keyDismissEye.isPressed())
		{
			SpellboundCore.keyBindHandler.keyDown(type, SpellboundCore.keyDismissEye, true, false);
		}
	}

	@Override
	public EnumSet<TickType> ticks() 
	{
		return EnumSet.of(TickType.CLIENT);
	}

	@Override
	public String getLabel() 
	{
		return "Spellbound - ClientTickHandler";
	}

}
