/**********************************************
 * SpellColdLvl3.java
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
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import spellbound.core.SpellboundCore;
import spellbound.enums.EnumItemInUseTime;
import spellbound.enums.EnumSpellRange;

public class SpellColdLvl3 extends AbstractSpell
{
	@Override
	public String getSpellDisplayName() 
	{
		return "Cold Blast";
	}

	@Override
	public void doSpellCasterEffect(EntityPlayer caster) 
	{
		if (!caster.worldObj.isRemote)
		{
			caster.worldObj.playSoundAtEntity(caster, "random.glass", 1.0F, 1.0F);

			int heading = MathHelper.floor_double((double)(caster.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;

			if (heading == 0)
			{
				for (int j = -3; j < 6; j++)
				{
					for (int i = 3; i < 14; i++)
					{			
						int blockId = caster.worldObj.getBlockId((int)caster.posX - j, (int)caster.posY, (int)caster.posZ + i);
						if (blockId == Block.snow.blockID || blockId == 0)
						{
							int radius = 2;

							caster.worldObj.setBlock((int)caster.posX - j, (int)caster.posY, (int)caster.posZ + i, Block.snow.blockID);

							for (Object obj : caster.worldObj.getEntitiesWithinAABBExcludingEntity(caster, AxisAlignedBB.getBoundingBox((int)caster.posX - radius - j, (int)caster.posY - 3, (int)caster.posZ + i - radius, (int)caster.posX + radius - j, (int)caster.posY + 3, (int)caster.posZ + i + radius)))
							{
								if (obj instanceof EntityLivingBase && !(obj instanceof EntityPlayer))
								{
									EntityLivingBase hitEntity = (EntityLivingBase)obj;
									hitEntity.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 1200));
									hitEntity.attackEntityFrom(DamageSource.magic, 12.0F);
								}
								
								else if (obj instanceof EntityPlayer)
								{
									if (!SpellboundCore.getInstance().playerHasActiveSpell((EntityPlayer)obj, SpellShieldOfInvulnerability.class) && !SpellboundCore.getInstance().playerHasActiveSpell((EntityPlayer)obj, SpellColdShield.class))
									{							
										EntityLivingBase hitEntity = (EntityLivingBase)obj;
										hitEntity.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 1200));
										hitEntity.attackEntityFrom(DamageSource.magic, 12.0F);
									}
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
						int blockId = caster.worldObj.getBlockId((int)caster.posX - i, (int)caster.posY, (int)caster.posZ - j);
						if (blockId == Block.snow.blockID || blockId == 0)
						{
							int radius = 2;

							for (Object obj : caster.worldObj.getEntitiesWithinAABBExcludingEntity(caster, AxisAlignedBB.getBoundingBox((int)caster.posX - radius - i, (int)caster.posY - 3, (int)caster.posZ - j - radius, (int)caster.posX + radius - i, (int)caster.posY + 3, (int)caster.posZ - j + radius)))
							{
								if (obj instanceof EntityLivingBase)
								{
									EntityLivingBase hitEntity = (EntityLivingBase)obj;
									hitEntity.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 1200));
									hitEntity.attackEntityFrom(DamageSource.magic, 12.0F);
								}
							}
							
							caster.worldObj.setBlock((int)caster.posX - i, (int)caster.posY, (int)caster.posZ - j, Block.snow.blockID);
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
						int blockId = caster.worldObj.getBlockId((int)caster.posX + j, (int)caster.posY, (int)caster.posZ - i);
						if (blockId == Block.snow.blockID || blockId == 0)
						{
							int radius = 2;

							for (Object obj : caster.worldObj.getEntitiesWithinAABBExcludingEntity(caster, AxisAlignedBB.getBoundingBox((int)caster.posX - radius + j, (int)caster.posY - 3, (int)caster.posZ - i - radius, (int)caster.posX + radius + j, (int)caster.posY + 3, (int)caster.posZ - i + radius)))
							{
								if (obj instanceof EntityLivingBase)
								{
									EntityLivingBase hitEntity = (EntityLivingBase)obj;
									hitEntity.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 1200));
									hitEntity.attackEntityFrom(DamageSource.magic, 12.0F);
								}
							}
							
							caster.worldObj.setBlock((int)caster.posX + j, (int)caster.posY, (int)caster.posZ - i, Block.snow.blockID);
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
						int blockId = caster.worldObj.getBlockId((int)caster.posX + i, (int)caster.posY, (int)caster.posZ + j);
						if (blockId == Block.snow.blockID || blockId == 0)
						{
							int radius = 2;

							for (Object obj : caster.worldObj.getEntitiesWithinAABBExcludingEntity(caster, AxisAlignedBB.getBoundingBox((int)caster.posX - radius + i, (int)caster.posY - 3, (int)caster.posZ + j - radius, (int)caster.posX + radius + i, (int)caster.posY + 3, (int)caster.posZ + j + radius)))
							{
								if (obj instanceof EntityLivingBase)
								{
									EntityLivingBase hitEntity = (EntityLivingBase)obj;
									hitEntity.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 1200));
									hitEntity.attackEntityFrom(DamageSource.magic, 12.0F);
								}
							}
							
							caster.worldObj.setBlock((int)caster.posX + i, (int)caster.posY, (int)caster.posZ + j, Block.snow.blockID);
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
	public void doSpellTargetEffect(World worldObj, int posX, int posY, int posZ, EntityLivingBase entityHit) 
	{
		//No target effect.
	}
	
	@Override
	public EnumItemInUseTime getSpellCastDuration() 
	{
		return EnumItemInUseTime.THREE_SECONDS;
	}
}
