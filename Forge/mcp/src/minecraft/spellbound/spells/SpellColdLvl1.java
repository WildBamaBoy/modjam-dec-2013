/**********************************************
 * SpellColdLvl1.java
 * Copyright (c) 2013 Wild Bama Boy.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl.html
 **********************************************/

package spellbound.spells;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
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

public class SpellColdLvl1 extends AbstractSpell
{
	@Override
	public String getSpellDisplayName() 
	{
		return "Icy Grip";
	}

	@Override
	public void doSpellCasterEffect(EntityPlayer caster) 
	{
		caster.inventory.decrStackSize(caster.inventory.currentItem, 1);
		caster.worldObj.playSoundAtEntity(caster, "random.glass", 1.0F, 1.0F);

		//TODO Redo.
		if (!caster.worldObj.isRemote)
		{
			int heading = MathHelper.floor_double((double)(caster.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;

			if (heading == 0)
			{
				for (int i = 3; i < 10; i++)
				{				
					int blockId = caster.worldObj.getBlockId((int)MathHelper.floor_double(caster.posX), (int)caster.posY, (int)MathHelper.floor_double(caster.posZ + i));
					if (blockId == Block.snow.blockID || blockId == 0)
					{
						int radius = 2;

						caster.worldObj.setBlock((int)MathHelper.floor_double(caster.posX), (int)caster.posY, (int)MathHelper.floor_double(caster.posZ + i), Block.snow.blockID);

						for (Object obj : caster.worldObj.getEntitiesWithinAABB(Entity.class, AxisAlignedBB.getBoundingBox((int)caster.posX - radius, (int)caster.posY - 3, (int)caster.posZ + i - radius, (int)caster.posX + radius, (int)caster.posY + 3, (int)caster.posZ + i + radius)))
						{
							if (obj instanceof EntityLivingBase && !(obj instanceof EntityPlayer))
							{
								EntityLivingBase hitEntity = (EntityLivingBase)obj;
								hitEntity.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 1200));
								hitEntity.attackEntityFrom(DamageSource.magic, 6.0F);
							}

							else if (obj instanceof EntityPlayer)
							{
								if (!SpellboundCore.getInstance().playerHasActiveSpell((EntityPlayer)obj, SpellShieldOfInvulnerability.class) && !SpellboundCore.getInstance().playerHasActiveSpell((EntityPlayer)obj, SpellColdShield.class))
								{							
									SpellboundCore.getInstance().addActiveSpellToPlayer(caster, this, 200);
								}
							}
						}
					}
				}
			}

			if (heading == 1)
			{
				for (int i = 3; i < 10; i++)
				{				
					int blockId = caster.worldObj.getBlockId((int)MathHelper.floor_double(caster.posX - i), (int)caster.posY, (int)MathHelper.floor_double(caster.posZ));
					if (blockId == Block.snow.blockID || blockId == 0)
					{
						caster.worldObj.setBlock((int)MathHelper.floor_double(caster.posX - i), (int)caster.posY, (int)MathHelper.floor_double(caster.posZ), Block.snow.blockID);
					}
					
					int radius = 2;
					for (Object obj : caster.worldObj.getEntitiesWithinAABB(Entity.class, AxisAlignedBB.getBoundingBox((int)caster.posX - radius - i, (int)caster.posY - 3, (int)caster.posZ - radius, (int)caster.posX - i + radius, (int)caster.posY + 3, (int)caster.posZ + radius)))
					{
						if (obj instanceof EntityLivingBase && !(obj instanceof EntityPlayer))
						{
							EntityLivingBase hitEntity = (EntityLivingBase)obj;
							hitEntity.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 1200));
							hitEntity.attackEntityFrom(DamageSource.magic, 6.0F);
						}

						else if (obj instanceof EntityPlayer)
						{
							if (!SpellboundCore.getInstance().playerHasActiveSpell((EntityPlayer)obj, SpellShieldOfInvulnerability.class) && !SpellboundCore.getInstance().playerHasActiveSpell((EntityPlayer)obj, SpellColdShield.class))
							{							
								SpellboundCore.getInstance().addActiveSpellToPlayer(caster, this, 200);
							}
						}
					}
				}
			}

			if (heading == 2)
			{
				for (int i = 3; i < 10; i++)
				{				
					int blockId = caster.worldObj.getBlockId((int)MathHelper.floor_double(caster.posX), (int)caster.posY, (int)MathHelper.floor_double(caster.posZ - i));
					if (blockId == Block.snow.blockID || blockId == 0)
					{
						caster.worldObj.setBlock((int)MathHelper.floor_double(caster.posX), (int)caster.posY, (int)MathHelper.floor_double(caster.posZ - i), Block.snow.blockID);
						
						int radius = 2;
						for (Object obj : caster.worldObj.getEntitiesWithinAABB(Entity.class, AxisAlignedBB.getBoundingBox((int)caster.posX - radius, (int)caster.posY - 3, (int)caster.posZ - i - radius, (int)caster.posX + radius, (int)caster.posY + 3, (int)caster.posZ - i + radius)))
						{
							if (obj instanceof EntityLivingBase && !(obj instanceof EntityPlayer))
							{
								EntityLivingBase hitEntity = (EntityLivingBase)obj;
								hitEntity.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 1200));
								hitEntity.attackEntityFrom(DamageSource.magic, 6.0F);
							}

							else if (obj instanceof EntityPlayer)
							{
								if (!SpellboundCore.getInstance().playerHasActiveSpell((EntityPlayer)obj, SpellShieldOfInvulnerability.class) && !SpellboundCore.getInstance().playerHasActiveSpell((EntityPlayer)obj, SpellColdShield.class))
								{							
									SpellboundCore.getInstance().addActiveSpellToPlayer(caster, this, 200);
								}
							}
						}
					}
				}
			}

			if (heading == 3)
			{
				for (int i = 3; i < 10; i++)
				{				
					int blockId = caster.worldObj.getBlockId((int)MathHelper.floor_double(caster.posX + i), (int)caster.posY, (int)MathHelper.floor_double(caster.posZ));
					if (blockId == Block.snow.blockID || blockId == 0)
					{
						caster.worldObj.setBlock((int)MathHelper.floor_double(caster.posX + i), (int)caster.posY, (int)MathHelper.floor_double(caster.posZ), Block.snow.blockID);
						
						int radius = 2;
						for (Object obj : caster.worldObj.getEntitiesWithinAABB(Entity.class, AxisAlignedBB.getBoundingBox((int)caster.posX + i - radius, (int)caster.posY - 3, (int)caster.posZ - radius, (int)caster.posX + i + radius, (int)caster.posY + 3, (int)caster.posZ + radius)))
						{
							if (obj instanceof EntityLivingBase && !(obj instanceof EntityPlayer))
							{
								EntityLivingBase hitEntity = (EntityLivingBase)obj;
								hitEntity.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 1200));
								hitEntity.attackEntityFrom(DamageSource.magic, 6.0F);
							}

							else if (obj instanceof EntityPlayer)
							{
								if (!SpellboundCore.getInstance().playerHasActiveSpell((EntityPlayer)obj, SpellShieldOfInvulnerability.class) && !SpellboundCore.getInstance().playerHasActiveSpell((EntityPlayer)obj, SpellColdShield.class))
								{							
									SpellboundCore.getInstance().addActiveSpellToPlayer(caster, this, 200);
								}
							}
						}
					}
				}
			}
		}
	}

	@Override
	public EnumSpellRange getSpellType() 
	{
		return EnumSpellRange.SELF;
	}

	@Override
	public void doSpellTargetEffect(World worldObj, int posX, int posY, int posZ, EntityLivingBase entityHit) 
	{
		//No target effect.
	}

	@Override
	public EnumItemInUseTime getSpellCastDuration() 
	{
		return EnumItemInUseTime.ONE_SECOND;
	}
}
