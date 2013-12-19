/**********************************************
 * ClientProxy.java
 * Copyright (c) 2013 Wild Bama Boy.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl.html
 **********************************************/

package spellbound.core.forge;

import net.minecraftforge.common.MinecraftForge;
import spellbound.core.SpellboundCore;
import spellbound.entity.EntityTargetSpellCold;
import spellbound.entity.EntityTargetSpellDisruption;
import spellbound.entity.EntityTargetSpellDivination;
import spellbound.entity.EntityTargetSpellFire;
import spellbound.entity.EntityTargetSpellLightning;
import spellbound.entity.EntityTargetSpellMundane;
import spellbound.render.RenderSpellTablet;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;

public class ClientProxy extends CommonProxy
{
	@Override
	public void registerRenderers()
	{
		RenderingRegistry.registerEntityRenderingHandler(EntityTargetSpellFire.class, new RenderSpellTablet(SpellboundCore.getInstance().itemTabletFireBase));
		RenderingRegistry.registerEntityRenderingHandler(EntityTargetSpellCold.class, new RenderSpellTablet(SpellboundCore.getInstance().itemTabletColdBase));
		RenderingRegistry.registerEntityRenderingHandler(EntityTargetSpellLightning.class, new RenderSpellTablet(SpellboundCore.getInstance().itemTabletLightningBase));
		RenderingRegistry.registerEntityRenderingHandler(EntityTargetSpellMundane.class, new RenderSpellTablet(SpellboundCore.getInstance().itemTabletMundaneBase));
		RenderingRegistry.registerEntityRenderingHandler(EntityTargetSpellDisruption.class, new RenderSpellTablet(SpellboundCore.getInstance().itemTabletDisruptionBase));
		RenderingRegistry.registerEntityRenderingHandler(EntityTargetSpellDivination.class, new RenderSpellTablet(SpellboundCore.getInstance().itemTabletDivinationBase));		
	}
	
	@Override
	public void registerTickHandlers() 
	{
		TickRegistry.registerTickHandler(new ServerTickHandler(), Side.SERVER);
	}
	
	@Override
	public void registerSounds()
	{
		MinecraftForge.EVENT_BUS.register(new EventHandler());
	}
}
