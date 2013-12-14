package spellbound.effects;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import spellbound.core.SB;
import spellbound.enums.EnumSpellType;

public class EffectDimensionDoor extends AbstractEffect
{
	@Override
	public String getSpellDisplayName() 
	{
		return "Dimension Door";
	}

	@Override
	public void doSpellEffect(EntityPlayer caster) 
	{
		if (!caster.worldObj.isRemote)
		{
			int heading = MathHelper.floor_double((double)(caster.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
			int transportAmount = SB.rand.nextInt(50) + 50;
			
			double newPlayerX = 0.0D;
			double newPlayerY = 0.0D;
			double newPlayerZ = 0.0D;
			
			if (heading == 0)
			{
				newPlayerX = caster.posX;
				newPlayerY = 255;
				newPlayerZ = caster.posZ + transportAmount;
			}
			
			if (heading == 1)
			{
				newPlayerX = caster.posX - transportAmount;
				newPlayerY = 255;
				newPlayerZ = caster.posZ;
			}
			
			if (heading == 2)
			{
				newPlayerX = caster.posX;
				newPlayerY = 255;
				newPlayerZ = caster.posZ - transportAmount;
			}
			
			if (heading == 3)
			{
				newPlayerX = caster.posX + transportAmount;
				newPlayerY = 255;
				newPlayerZ = caster.posZ;
			}
			
			//Find first obstruction free block
			while (caster.worldObj.getBlockId((int)newPlayerX, (int)newPlayerY, (int)newPlayerZ) != 0)
			{
				
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
		return EnumSpellType.SELF;
	}

	@Override
	public void doSpellTargetEffect(World worldObj, int posX, int posY, int posZ) 
	{
	}
}
