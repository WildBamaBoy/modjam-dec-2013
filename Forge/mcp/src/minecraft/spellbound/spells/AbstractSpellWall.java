/**********************************************
 * AbstractSpellWall.java
 * Copyright (c) 2013 Wild Bama Boy.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl.html
 **********************************************/

package spellbound.spells;

import net.minecraft.block.Block;
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

		final int heading = MathHelper.floor_double((double)(caster.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
		final boolean isOverhead = caster.rotationPitch <= -60.0D;
		final boolean isUnderneath = caster.rotationPitch >= 60.0D;

		double centerX = caster.posX;
		double centerY = caster.posY;
		double centerZ = caster.posZ;

		if (isOverhead)
		{
			for (int currentWidth = -3; currentWidth < 2; currentWidth++)
			{
				for (int currentHeight = -2; currentHeight < 3; currentHeight++)
				{
					caster.worldObj.setBlock((int)centerX + currentWidth, (int)centerY + 3, (int)centerZ + currentHeight, getWallBlockId());
				}
			}
		}

		else if (isUnderneath)
		{
			for (int currentWidth = -3; currentWidth < 2; currentWidth++)
			{
				for (int currentHeight = -2; currentHeight < 3; currentHeight++)
				{
					if (caster.worldObj.getBlockId((int)centerX + currentWidth, (int)centerY - 1, (int)centerZ + currentHeight) != Block.bedrock.blockID)
					{
						caster.worldObj.setBlock((int)centerX + currentWidth, (int)centerY - 1, (int)centerZ + currentHeight, getWallBlockId());
					}
				}
			}
		}

		else
		{
			switch (heading)
			{
			case 0: centerZ += 3; break;
			case 1: centerX -= 3; break;
			case 2: centerZ -= 3; break;
			case 3: centerX += 3; break;
			default: break;
			}

			centerX = MathHelper.floor_double(centerX);
			centerY = MathHelper.floor_double(centerY);
			centerZ = MathHelper.floor_double(centerZ);

			for (int currentWidth = -3; currentWidth < 4; currentWidth++)
			{
				for (int currentHeight = 0; currentHeight < 3; currentHeight++)
				{
					switch (heading)
					{
					case 0: 
						caster.worldObj.setBlock((int)centerX + currentWidth, (int)centerY + currentHeight, (int)centerZ, getWallBlockId());
						break;
					case 1: 
						caster.worldObj.setBlock((int)centerX, (int)centerY + currentHeight, (int)centerZ + currentWidth, getWallBlockId()); 
						break;
					case 2: 
						caster.worldObj.setBlock((int)centerX + currentWidth, (int)centerY + currentHeight, (int)centerZ, getWallBlockId()); 
						break;
					case 3: 
						caster.worldObj.setBlock((int)centerX, (int)centerY + currentHeight, (int)centerZ - currentWidth, getWallBlockId());
						break;
					default: break;
					}
				}
			}
		}

		PacketDispatcher.sendPacketToAllPlayers(PacketHandler.createWallGFXPacket(heading, centerX, centerY, centerZ, isOverhead, isUnderneath));
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
