/**********************************************
 * RenderSpellTablet.java
 * Copyright (c) 2013 Wild Bama Boy.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl.html
 **********************************************/

package spellbound.render;

import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.util.Icon;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderSpellTablet extends Render
{
	private Item renderItem;
	private int itemDamage;

	public RenderSpellTablet(Item renderItem, int itemDamage)
	{
		this.renderItem = renderItem;
		this.itemDamage = itemDamage;
	}

	public RenderSpellTablet(Item renderItem)
	{
		this(renderItem, 0);
	}

	public void doRender(Entity entity, double posX, double posY, double posZ, float rotationPitch, float rotationYaw)
	{
		final Icon icon = this.renderItem.getIconFromDamage(this.itemDamage);

		if (icon != null)
		{
			GL11.glPushMatrix();
			GL11.glTranslatef((float)posX, (float)posY, (float)posZ);
			GL11.glEnable(GL12.GL_RESCALE_NORMAL);
			GL11.glScalef(1.5F, 1.5F, 1.5F);
			this.bindEntityTexture(entity);

			final Tessellator tessellator = Tessellator.instance;

			this.drawIcon(tessellator, icon);
			GL11.glDisable(GL12.GL_RESCALE_NORMAL);
			GL11.glPopMatrix();
		}
	}

	protected ResourceLocation getEntityTexture(Entity par1Entity)
	{
		return TextureMap.locationItemsTexture;
	}

	private void drawIcon(Tessellator tessellator, Icon icon)
	{
		final float minU = icon.getMinU();
		final float maxU = icon.getMaxU();
		final float minV = icon.getMinV();
		final float maxV = icon.getMaxV();

		GL11.glRotatef(180.0F - this.renderManager.playerViewY, 0.0F, 1.0F, 0.0F);
		GL11.glRotatef(-this.renderManager.playerViewX, 1.0F, 0.0F, 0.0F);

		tessellator.startDrawingQuads();
		{
			tessellator.setNormal(0.0F, 1.0F, 0.0F);
			tessellator.addVertexWithUV(-0.5D, -0.25D, 0.0D, minU, maxV);
			tessellator.addVertexWithUV(0.5D, -0.25D, 0.0D, maxU, maxV);
			tessellator.addVertexWithUV(0.5D, 0.75D, 0.0D, maxU, minV);
			tessellator.addVertexWithUV(-0.5D, 0.75D, 0.0D, minU, minV);
		}
		tessellator.draw();
	}
}
