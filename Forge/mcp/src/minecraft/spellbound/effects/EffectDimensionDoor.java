package spellbound.effects;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
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
			caster.worldObj.playSoundAtEntity(caster, "mob.endermen.portal", 1.0F, 1.0F);
			
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
			
			else if (heading == 1)
			{
				newPlayerX = caster.posX - transportAmount;
				newPlayerY = 255;
				newPlayerZ = caster.posZ;
			}
			
			else if (heading == 2)
			{
				newPlayerX = caster.posX;
				newPlayerY = 255;
				newPlayerZ = caster.posZ - transportAmount;
			}
			
			else if (heading == 3)
			{
				newPlayerX = caster.posX + transportAmount;
				newPlayerY = 255;
				newPlayerZ = caster.posZ;
			}
			
			while (caster.worldObj.getBlockId((int)newPlayerX, (int)newPlayerY, (int)newPlayerZ) == 0 && newPlayerY != 0)
			{
				newPlayerY--;
			}
			
			EntityPlayerMP casterMP = (EntityPlayerMP)caster;
			casterMP.mountEntity((Entity)null);
			casterMP.playerNetServerHandler.setPlayerLocation(newPlayerX, newPlayerY, newPlayerZ, caster.rotationYaw, caster.rotationPitch);
			caster.worldObj.playSoundAtEntity(casterMP, "mob.endermen.portal", 1.0F, 1.0F);
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
