/**********************************************
 * SpellPanicRoom.java
 * Copyright (c) 2013 Wild Bama Boy.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl.html
 **********************************************/

package spellbound.spells;

import cpw.mods.fml.common.network.PacketDispatcher;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import spellbound.core.SpellboundCore;
import spellbound.core.forge.PacketHandler;
import spellbound.enums.EnumItemInUseTime;
import spellbound.enums.EnumSpellRange;

public class SpellPanicRoom extends AbstractSpell
{

	@Override
	public String getSpellDisplayName() 
	{
		return "Panic Room";
	}

	@Override
	public EnumItemInUseTime getSpellCastDuration() 
	{
		return EnumItemInUseTime.FIVE_SECONDS;
	}

	@Override
	public void doSpellCasterEffect(EntityPlayer caster) 
	{
		caster.worldObj.playSoundAtEntity(caster, "mob.endermen.portal", 1.0F, 1.0F);

		for (int loops = 0; loops < 6; loops++)
		{
			final int heading = loops;
			final boolean isOverhead = loops == 4;
			final boolean isUnderneath = loops == 5;

			double centerX = caster.posX;
			double centerY = caster.posY;
			double centerZ = caster.posZ;

			if (isOverhead)
			{
				for (int currentWidth = -3; currentWidth < 2; currentWidth++)
				{
					for (int currentHeight = -2; currentHeight < 3; currentHeight++)
					{
						caster.worldObj.setBlock((int)centerX + currentWidth, (int)centerY + 3, (int)centerZ + currentHeight, SpellboundCore.getInstance().blockFalseBedrock.blockID);
					}
				}
			}

			else if (isUnderneath)
			{
				for (int currentWidth = -3; currentWidth < 2; currentWidth++)
				{
					for (int currentHeight = -2; currentHeight < 3; currentHeight++)
					{
						if (caster.worldObj.getBlockId((int)centerX + currentWidth, (int)centerY - 1, (int)centerZ + currentHeight) != SpellboundCore.getInstance().blockFalseBedrock.blockID)
						{
							caster.worldObj.setBlock((int)centerX + currentWidth, (int)centerY - 1, (int)centerZ + currentHeight, SpellboundCore.getInstance().blockFalseBedrock.blockID);
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
							caster.worldObj.setBlock((int)centerX + currentWidth, (int)centerY + currentHeight, (int)centerZ, SpellboundCore.getInstance().blockFalseBedrock.blockID);
							break;
						case 1: 
							caster.worldObj.setBlock((int)centerX, (int)centerY + currentHeight, (int)centerZ + currentWidth, SpellboundCore.getInstance().blockFalseBedrock.blockID); 
							break;
						case 2: 
							caster.worldObj.setBlock((int)centerX + currentWidth, (int)centerY + currentHeight, (int)centerZ, SpellboundCore.getInstance().blockFalseBedrock.blockID); 
							break;
						case 3: 
							caster.worldObj.setBlock((int)centerX, (int)centerY + currentHeight, (int)centerZ - currentWidth, SpellboundCore.getInstance().blockFalseBedrock.blockID);
							break;
						default: break;
						}
					}
				}
			}

			PacketDispatcher.sendPacketToAllPlayers(PacketHandler.createWallGFXPacket(heading, centerX, centerY, centerZ, isOverhead, isUnderneath));
		}
	}

	@Override
	public void doSpellTargetEffect(World worldObj, int posX, int posY, int posZ, EntityLivingBase entityHit) 
	{
		//No target effect.
	}

	@Override
	public EnumSpellRange getSpellType() 
	{
		return EnumSpellRange.SELF;
	}
}
