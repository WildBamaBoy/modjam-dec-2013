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

		final boolean addX = heading == 2 || heading == 3;
		final boolean addZ = heading == 0 || heading == 3;

		Integer dummy = 0;
		Integer length = 0;

		for (length = 3; length < 14; length++)
		{
			final int flooredX = MathHelper.floor_double(caster.posX);
			final int flooredZ = MathHelper.floor_double(caster.posZ);

			final int xCounter = heading == 0 || heading == 2 ? dummy : length;
			final int zCounter = heading == 0 || heading == 2 ? length : dummy;

			final int posX = addX ? flooredX + xCounter : flooredX - xCounter;
			final int posY = (int) caster.posY;
			final int posZ = addZ ? flooredZ + zCounter : flooredZ - zCounter;

			final int blockId = caster.worldObj.getBlockId(posX, posY, posZ);

			if (blockId == Block.snow.blockID || blockId == 0)
			{
				caster.worldObj.setBlock(posX, posY, posZ, Block.fire.blockID);
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
