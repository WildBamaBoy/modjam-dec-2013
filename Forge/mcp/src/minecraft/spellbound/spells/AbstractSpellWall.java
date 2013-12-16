package spellbound.spells;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import spellbound.enums.EnumSpellType;

public abstract class AbstractSpellWall extends AbstractSpell
{
	@Override
	public void doSpellCasterEffect(EntityPlayer caster) 
	{
		caster.worldObj.playSoundAtEntity(caster, "mob.endermen.portal", 1.0F, 1.0F);

		if (!caster.worldObj.isRemote)
		{
			final int heading = MathHelper.floor_double((double)(caster.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;

			int wallCenterX = (int) caster.posX;
			int wallCenterY = (int) caster.posY;
			int wallCenterZ = (int) caster.posZ;

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

			for (int currentWidth = -3; currentWidth < 4; currentWidth++)
			{
				for (int currentHeight = 0; currentHeight < 3; currentHeight++)
				{
					switch (heading)
					{
					case 0: caster.worldObj.setBlock(wallCenterX + currentWidth, wallCenterY + currentHeight, wallCenterZ, getWallBlockId()); break;
					case 1: caster.worldObj.setBlock(wallCenterX, wallCenterY + currentHeight, wallCenterZ + currentWidth, getWallBlockId()); break;
					case 2: caster.worldObj.setBlock(wallCenterX + currentWidth, wallCenterY + currentHeight, wallCenterZ, getWallBlockId()); break;
					case 3: caster.worldObj.setBlock(wallCenterX, wallCenterY + currentHeight, wallCenterZ - currentWidth, getWallBlockId()); break;
					default: break;
					}
				}
			}
		}
	}
	
	@Override
	public EnumSpellType getSpellType() 
	{
		return EnumSpellType.FRONT;
	}

	@Override
	public void doSpellTargetEffect(World worldObj, int posX, int posY, int posZ, EntityLivingBase entityHit) 
	{
		//No target effect.
	}

	public abstract int getWallBlockId();
}
