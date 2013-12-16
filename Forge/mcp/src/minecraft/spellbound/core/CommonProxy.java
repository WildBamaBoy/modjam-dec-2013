package spellbound.core;

import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;

public class CommonProxy 
{
	public void registerRenderers()
	{
		//Server-side.
	}

	public void registerTickHandlers()
	{
		//TickRegistry.registerTickHandler(new ClientTickHandler(), Side.CLIENT);
		TickRegistry.registerTickHandler(new ServerTickHandler(), Side.SERVER);
	}

	public void registerSounds() 
	{
		
	}
}
