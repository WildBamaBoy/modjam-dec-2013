/**********************************************
 * AbstractSpellWall.java
 * Copyright (c) 2013 Wild Bama Boy.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl.html
 **********************************************/

package spellbound.spells;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import spellbound.core.SpellboundCore;
import spellbound.core.forge.PacketHandler;
import spellbound.enums.EnumSpellRange;
import cpw.mods.fml.common.network.PacketDispatcher;

public abstract class AbstractSpellWall extends AbstractSpell
{
	@Override
	public final void doSpellCasterEffect(EntityPlayer caster) 
	{
		caster.worldObj.playSoundAtEntity(caster, "mob.endermen.portal", 1.0F, 1.0F);

		if (!caster.worldObj.isRemote)
		{
			final int heading = MathHelper.floor_double((double)(caster.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;

			double wallCenterX = caster.posX;
			double wallCenterY = caster.posY;
			double wallCenterZ = caster.posZ;

			switch (heading)
			{
			case 0: wallCenterZ += 3; break;
			case 1: wallCenterX -= 3; break;
			case 2: wallCenterZ -= 3; break;
			case 3: wallCenterX += 3; break;
			default: break;
			}

			wallCenterX = MathHelper.floor_double(wallCenterX);
			wallCenterY = MathHelper.floor_double(wallCenterY);
			wallCenterZ = MathHelper.floor_double(wallCenterZ);

			PacketDispatcher.sendPacketToAllPlayers(PacketHandler.createWallParticlesPacket(heading, wallCenterX, wallCenterY, wallCenterZ));
			for (int currentWidth = -3; currentWidth < 4; currentWidth++)
			{
				for (int currentHeight = 0; currentHeight < 3; currentHeight++)
				{
					switch (heading)
					{
					case 0: 
						caster.worldObj.setBlock((int)wallCenterX + currentWidth, (int)wallCenterY + currentHeight, (int)wallCenterZ, getWallBlockId());
						break;
					case 1: 
						caster.worldObj.setBlock((int)wallCenterX, (int)wallCenterY + currentHeight, (int)wallCenterZ + currentWidth, getWallBlockId()); 
						break;
					case 2: 
						caster.worldObj.setBlock((int)wallCenterX + currentWidth, (int)wallCenterY + currentHeight, (int)wallCenterZ, getWallBlockId()); 
						break;
					case 3: 
						caster.worldObj.setBlock((int)wallCenterX, (int)wallCenterY + currentHeight, (int)wallCenterZ - currentWidth, getWallBlockId());
						break;
					default: break;
					}
				}
			}
		}
	}
	
	@Override
	public final EnumSpellRange getSpellType() 
	{
		return EnumSpellRange.FRONT;
	}

	@Override
	public final void doSpellTargetEffect(World worldObj, int posX, int posY, int posZ, EntityLivingBase entityHit) 
	{
		//No target effect.
	}

	public abstract int getWallBlockId();
	
	public static void addParticles(World world, double posX, double posY, double posZ)
	{
		double velX = SpellboundCore.modRandom.nextGaussian() * 0.02D;
		double velY = SpellboundCore.modRandom.nextGaussian() * 0.02D;
		double velZ = SpellboundCore.modRandom.nextGaussian() * 0.02D;
		
		for (int i = 0; i < 6; i++)
		{
			world.spawnParticle("happyVillager", posX + SpellboundCore.modRandom.nextFloat(), posY + SpellboundCore.modRandom.nextFloat(), posZ + SpellboundCore.modRandom.nextFloat(), velX, velY, velZ);
		}
	}
}
