package spellbound.core;

import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import spellbound.entity.EntityAllSeeingEye;
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
		RenderingRegistry.registerEntityRenderingHandler(EntityAllSeeingEye.class, new RenderSpellTablet(Item.eyeOfEnder));
		
		RenderingRegistry.registerEntityRenderingHandler(EntityTargetSpellFire.class, new RenderSpellTablet(SpellboundCore.instance.itemTabletFireBase));
		RenderingRegistry.registerEntityRenderingHandler(EntityTargetSpellCold.class, new RenderSpellTablet(SpellboundCore.instance.itemTabletColdBase));
		RenderingRegistry.registerEntityRenderingHandler(EntityTargetSpellLightning.class, new RenderSpellTablet(SpellboundCore.instance.itemTabletLightningBase));
		RenderingRegistry.registerEntityRenderingHandler(EntityTargetSpellMundane.class, new RenderSpellTablet(SpellboundCore.instance.itemTabletMundaneBase));
		RenderingRegistry.registerEntityRenderingHandler(EntityTargetSpellDisruption.class, new RenderSpellTablet(SpellboundCore.instance.itemTabletDisruptionBase));
		RenderingRegistry.registerEntityRenderingHandler(EntityTargetSpellDivination.class, new RenderSpellTablet(SpellboundCore.instance.itemTabletDivinationBase));		
	}
	
	@Override
	public void registerTickHandlers() 
	{
		TickRegistry.registerTickHandler(new ClientTickHandler(), Side.CLIENT);
		TickRegistry.registerTickHandler(new ServerTickHandler(), Side.SERVER);
	}
	
	@Override
	public void registerSounds()
	{
		MinecraftForge.EVENT_BUS.register(new EventHandler());
	}
}
