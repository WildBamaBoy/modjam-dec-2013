package spellbound.core;

import spellbound.entity.EntityAllSeeingEye;
import spellbound.entity.EntityTargetSpellCold;
import spellbound.entity.EntityTargetSpellDisruption;
import spellbound.entity.EntityTargetSpellDivination;
import spellbound.entity.EntityTargetSpellFire;
import spellbound.entity.EntityTargetSpellLightning;
import spellbound.entity.EntityTargetSpellMundane;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;

public class ClientProxy extends CommonProxy
{
	@Override
	public void registerRenderers()
	{
		RenderingRegistry.registerEntityRenderingHandler(EntityAllSeeingEye.class, new RenderSnowball(Item.eyeOfEnder));
		
		RenderingRegistry.registerEntityRenderingHandler(EntityTargetSpellFire.class, new RenderSnowball(SpellboundCore.instance.itemTabletFireBase));
		RenderingRegistry.registerEntityRenderingHandler(EntityTargetSpellCold.class, new RenderSnowball(SpellboundCore.instance.itemTabletColdBase));
		RenderingRegistry.registerEntityRenderingHandler(EntityTargetSpellLightning.class, new RenderSnowball(SpellboundCore.instance.itemTabletLightningBase));
		RenderingRegistry.registerEntityRenderingHandler(EntityTargetSpellMundane.class, new RenderSnowball(SpellboundCore.instance.itemTabletMundaneBase));
		RenderingRegistry.registerEntityRenderingHandler(EntityTargetSpellDisruption.class, new RenderSnowball(SpellboundCore.instance.itemTabletDisruptionBase));
		RenderingRegistry.registerEntityRenderingHandler(EntityTargetSpellDivination.class, new RenderSnowball(SpellboundCore.instance.itemTabletDivinationBase));		
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
