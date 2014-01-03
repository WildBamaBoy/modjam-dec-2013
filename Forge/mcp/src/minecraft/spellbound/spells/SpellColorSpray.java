/**********************************************
 * SpellColorSpray.java
 * Copyright (c) 2013 Wild Bama Boy.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl.html
 **********************************************/

package spellbound.spells;

import net.minecraft.block.Block;
import net.minecraft.block.BlockColored;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import spellbound.core.SpellboundCore;
import spellbound.core.forge.PacketHandler;
import spellbound.enums.EnumItemInUseTime;
import spellbound.enums.EnumSpellRange;
import cpw.mods.fml.common.network.PacketDispatcher;

public class SpellColorSpray extends AbstractSpell
{
	@Override
	public String getSpellDisplayName() 
	{
		return "Color Spray";
	}

	@Override
	public void doSpellCasterEffect(EntityPlayer caster) 
	{
		caster.worldObj.playSoundAtEntity(caster, "mob.ghast.fireball", 1.0F, 1.0F);

		final int heading = MathHelper.floor_double((double)(caster.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;

		final boolean addX = heading == 2 || heading == 3;
		final boolean addZ = heading == 0 || heading == 3;

		Integer width = 0;
		Integer length = 0;

		for (width = -3; width < 6; width++)
		{
			for (length = 3; length < 14; length++)
			{
				final int flooredX = MathHelper.floor_double(caster.posX);
				final int flooredZ = MathHelper.floor_double(caster.posZ);

				final int xCounter = heading == 0 || heading == 2 ? width : length;
				final int zCounter = heading == 0 || heading == 2 ? length : width;

				final int radius = 6;
				final int posX = addX ? flooredX + xCounter : flooredX - xCounter;
				final int posY = (int) caster.posY;
				final int posZ = addZ ? flooredZ + zCounter : flooredZ - zCounter;
				final int blockId = caster.worldObj.getBlockId(posX, posY, posZ);

				for (final Object obj : caster.worldObj.getEntitiesWithinAABBExcludingEntity(caster, AxisAlignedBB.getBoundingBox(posX - radius, posY - 3, posZ - radius, posX + radius, posY + 3, posZ + radius)))
				{
					if (obj instanceof EntityLivingBase && !(obj instanceof EntityPlayer))
					{
						final EntityLivingBase hitEntity = (EntityLivingBase)obj;
						hitEntity.addPotionEffect(new PotionEffect(Potion.blindness.id, 200));

						if (obj instanceof EntitySheep)
						{
							final EntitySheep entitySheep = (EntitySheep)obj;
							entitySheep.setFleeceColor(BlockColored.getDyeFromBlock(SpellboundCore.modRandom.nextInt(16)));
						}
					}

					else if (obj instanceof EntityPlayer && !SpellboundCore.getInstance().entityHasActiveSpell((EntityPlayer)obj, SpellShieldOfInvulnerability.class) && !SpellboundCore.getInstance().entityHasActiveSpell((EntityPlayer)obj, SpellColdShield.class))
					{
						final EntityLivingBase hitEntity = (EntityLivingBase)obj;
						hitEntity.addPotionEffect(new PotionEffect(Potion.blindness.id, 200));
					}
				}

				for (int movY = 0; movY < 3; movY++)
				{
					if (blockId == Block.cloth.blockID)
					{
						caster.worldObj.setBlockMetadataWithNotify(posX, posY + movY, posZ, SpellboundCore.modRandom.nextInt(16), 2);
					}
				}
			}
		}

		PacketDispatcher.sendPacketToAllPlayers(PacketHandler.createColorGFXPacket(heading, caster.posX, caster.posY, caster.posZ));
	}

	@Override
	public EnumSpellRange getSpellType() 
	{
		return EnumSpellRange.FRONT;
	}

	@Override
	public void doSpellTargetEffect(World worldObj, int posX, int posY, int posZ, EntityLivingBase entityHit) 
	{
		//No target effect.
	}

	@Override
	public EnumItemInUseTime getSpellCastDuration() 
	{
		return EnumItemInUseTime.TWO_SECONDS;
	}
}
