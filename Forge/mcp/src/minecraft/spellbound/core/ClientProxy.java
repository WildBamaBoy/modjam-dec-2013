package spellbound.core;

import spellbound.entity.EntityFireball;
import net.minecraft.client.renderer.entity.RenderFireball;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy
{
	public void registerRenderers()
	{
		RenderingRegistry.registerEntityRenderingHandler(EntityFireball.class, new RenderFireball(1.0F));
	}
}
