/**********************************************
 * SpellFireLvl1.java
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
import spellbound.enums.EnumItemInUseTime;
import spellbound.enums.EnumSpellRange;

public class SpellFireLvl1 extends AbstractSpell
{
	@Override
	public String getSpellDisplayName() 
	{
		return "Flaming Hands";
	}

	@Override
	public void doSpellCasterEffect(EntityPlayer caster) 
	{
		caster.worldObj.playSoundAtEntity(caster, "mob.ghast.fireball", 1.0F, 1.0F);
		
		final int heading = MathHelper.floor_double((double)(caster.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
		
		if (heading == 0)
		{
			for (int i = 3; i < 10; i++)
			{				
				final int blockId = caster.worldObj.getBlockId((int)MathHelper.floor_double(caster.posX), (int)caster.posY, (int)MathHelper.floor_double(caster.posZ + i));
				if (blockId == Block.snow.blockID || blockId == 0 || blockId == Block.tallGrass.blockID)
				{
					caster.worldObj.setBlock((int)MathHelper.floor_double(caster.posX), (int)caster.posY, (int)MathHelper.floor_double(caster.posZ + i), Block.fire.blockID);
				}
			}
		}
		
		if (heading == 1)
		{
			for (int i = 3; i < 10; i++)
			{				
				final int blockId = caster.worldObj.getBlockId((int)MathHelper.floor_double(caster.posX - i), (int)caster.posY, (int)MathHelper.floor_double(caster.posZ));
				if (blockId == Block.snow.blockID || blockId == 0 || blockId == Block.tallGrass.blockID)
				{
					caster.worldObj.setBlock((int)MathHelper.floor_double(caster.posX - i), (int)caster.posY, (int)MathHelper.floor_double(caster.posZ), Block.fire.blockID);
				}
			}
		}
		
		if (heading == 2)
		{
			for (int i = 3; i < 10; i++)
			{				
				final int blockId = caster.worldObj.getBlockId((int)MathHelper.floor_double(caster.posX), (int)caster.posY, (int)MathHelper.floor_double(caster.posZ - i));
				if (blockId == Block.snow.blockID || blockId == 0 || blockId == Block.tallGrass.blockID)
				{
					caster.worldObj.setBlock((int)MathHelper.floor_double(caster.posX), (int)caster.posY, (int)MathHelper.floor_double(caster.posZ - i), Block.fire.blockID);
				}
			}
		}
		
		if (heading == 3)
		{
			for (int i = 3; i < 10; i++)
			{				
				final int blockId = caster.worldObj.getBlockId((int)MathHelper.floor_double(caster.posX + i), (int)caster.posY, (int)MathHelper.floor_double(caster.posZ));
				if (blockId == Block.snow.blockID || blockId == 0 || blockId == Block.tallGrass.blockID)
				{
					caster.worldObj.setBlock((int)MathHelper.floor_double(caster.posX + i), (int)caster.posY, (int)MathHelper.floor_double(caster.posZ), Block.fire.blockID);
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
		return EnumItemInUseTime.ONE_SECOND;
	}
}
