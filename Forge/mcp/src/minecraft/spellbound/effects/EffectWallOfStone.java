package spellbound.effects;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import spellbound.core.SB;
import spellbound.enums.EnumSpellType;

public class EffectWallOfStone extends AbstractEffectWall
{
	@Override
	public String getSpellDisplayName() 
	{
		return "Wall of Stone";
	}

	@Override
	public void doSpellEffect(EntityPlayer caster) 
	{
		caster.worldObj.playSoundAtEntity(caster, "mob.endermen.portal", 1.0F, 1.0F);

		int heading = MathHelper.floor_double((double)(caster.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;

		int wallCenterX = 0;
		int wallCenterY = 0;
		int wallCenterZ = 0;

		if (heading == 0)
		{
			wallCenterX = (int) caster.posX;
			wallCenterY = (int) caster.posY;
			wallCenterZ = (int) (caster.posZ + 3);
		}

		else if (heading == 1)
		{
			wallCenterX = (int) (caster.posX - 3);
			wallCenterY = (int) caster.posY;
			wallCenterZ = (int) caster.posZ;
		}

		else if (heading == 2)
		{
			wallCenterX = (int) caster.posX;
			wallCenterY = (int) caster.posY;
			wallCenterZ = (int) (caster.posZ - 3);
		}

		else if (heading == 3)
		{
			wallCenterX = (int) (caster.posX + 3);
			wallCenterY = (int) caster.posY;
			wallCenterZ = (int) caster.posZ;
		}
		
		for (int i = -3; i < 4; i++)
		{
			for (int j = 0; j < 3; j++)
			{
				if (heading == 0)
				{
					caster.worldObj.setBlock(wallCenterX + i, wallCenterY + j, wallCenterZ, getWallBlockId());
				}

				else if (heading == 1)
				{
					caster.worldObj.setBlock(wallCenterX, wallCenterY + j, wallCenterZ + i, getWallBlockId());
				}

				else if (heading == 2)
				{
					caster.worldObj.setBlock(wallCenterX + i, wallCenterY + j, wallCenterZ, getWallBlockId());
				}

				else if (heading == 3)
				{
					caster.worldObj.setBlock(wallCenterX, wallCenterY + j, wallCenterZ - i, getWallBlockId());
				}
			}
		}
	}

	@Override
	public void updateSpellEffect() 
	{

	}

	@Override
	public EnumSpellType getSpellType() 
	{
		return EnumSpellType.FRONT;
	}

	@Override
	public int getWallBlockId() 
	{
		return Block.stone.blockID;
	}

	@Override
	public void doSpellTargetEffect(World worldObj, int posX, int posY, int posZ) {
		// TODO Auto-generated method stub

	}
}
