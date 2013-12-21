/**********************************************
 * SpellColorSpray.java
 * Copyright (c) 2013 Wild Bama Boy.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl.html
 **********************************************/

package spellbound.spells;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import spellbound.core.SpellboundCore;
import spellbound.enums.EnumItemInUseTime;
import spellbound.enums.EnumSpellRange;

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

		int heading = MathHelper.floor_double((double)(caster.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;

		if (heading == 0)
		{
			for (int j = -3; j < 6; j++)
			{
				for (int i = 3; i < 14; i++)
				{			
					int radius = 2;

					for (Object obj : caster.worldObj.getEntitiesWithinAABBExcludingEntity(caster, AxisAlignedBB.getBoundingBox((int)caster.posX - radius - j, (int)caster.posY - 3, (int)caster.posZ + i - radius, (int)caster.posX + radius - j, (int)caster.posY + 3, (int)caster.posZ + i + radius)))
					{
						if (obj instanceof EntityLivingBase && !(obj instanceof EntityPlayer))
						{
							EntityLivingBase hitEntity = (EntityLivingBase)obj;
							hitEntity.addPotionEffect(new PotionEffect(Potion.blindness.id, 400));
						}

						else if (obj instanceof EntityPlayer)
						{
							if (!SpellboundCore.getInstance().playerHasActiveSpell((EntityPlayer)obj, SpellShieldOfInvulnerability.class))
							{
								EntityLivingBase hitEntity = (EntityLivingBase)obj;
								hitEntity.addPotionEffect(new PotionEffect(Potion.blindness.id, 400));	
							}
						}
					}
				}
			}
		}

		if (heading == 1)
		{
			for (int j = -3; j < 6; j++)
			{
				for (int i = 3; i < 14; i++)
				{				
					int radius = 2;

					for (Object obj : caster.worldObj.getEntitiesWithinAABBExcludingEntity(caster, AxisAlignedBB.getBoundingBox((int)caster.posX - radius - i, (int)caster.posY - 3, (int)caster.posZ - j - radius, (int)caster.posX + radius - i, (int)caster.posY + 3, (int)caster.posZ - j + radius)))
					{
						if (obj instanceof EntityLivingBase)
						{
							EntityLivingBase hitEntity = (EntityLivingBase)obj;
							hitEntity.addPotionEffect(new PotionEffect(Potion.blindness.id, 1200));
						}
					}
				}
			}
		}

		if (heading == 2)
		{
			for (int j = -3; j < 6; j++)
			{
				for (int i = 3; i < 14; i++)
				{					
					int radius = 2;

					for (Object obj : caster.worldObj.getEntitiesWithinAABBExcludingEntity(caster, AxisAlignedBB.getBoundingBox((int)caster.posX - radius + j, (int)caster.posY - 3, (int)caster.posZ - i - radius, (int)caster.posX + radius + j, (int)caster.posY + 3, (int)caster.posZ - i + radius)))
					{
						if (obj instanceof EntityLivingBase)
						{
							EntityLivingBase hitEntity = (EntityLivingBase)obj;
							hitEntity.addPotionEffect(new PotionEffect(Potion.blindness.id, 1200));
						}
					}
				}
			}
		}

		if (heading == 3)
		{
			for (int j = -3; j < 6; j++)
			{
				for (int i = 3; i < 14; i++)
				{					
					int radius = 2;

					for (Object obj : caster.worldObj.getEntitiesWithinAABBExcludingEntity(caster, AxisAlignedBB.getBoundingBox((int)caster.posX - radius + i, (int)caster.posY - 3, (int)caster.posZ + j - radius, (int)caster.posX + radius + i, (int)caster.posY + 3, (int)caster.posZ + j + radius)))
					{
						if (obj instanceof EntityLivingBase)
						{
							EntityLivingBase hitEntity = (EntityLivingBase)obj;
							hitEntity.addPotionEffect(new PotionEffect(Potion.blindness.id, 1200));
						}
					}
				}
			}
		}
	}

	@Override
	public EnumSpellRange getSpellType() 
	{
		return EnumSpellRange.FRONT;
	}

	@Override
	public void doSpellTargetEffect(World worldObj, int posX, int posY, int posZ, EntityLivingBase entityHit) {
		// TODO Auto-generated method stub

	}

	@Override
	public EnumItemInUseTime getSpellCastDuration() 
	{
		return EnumItemInUseTime.TWO_SECONDS;
	}
}
