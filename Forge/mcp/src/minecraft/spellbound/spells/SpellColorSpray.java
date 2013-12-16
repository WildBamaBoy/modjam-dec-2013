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
import spellbound.enums.EnumSpellType;

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
		if (!caster.worldObj.isRemote)
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
								if (!SpellboundCore.instance.playerHasActiveSpell((EntityPlayer)obj, "SpellShieldOfInvulnerability"))
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
	}

	@Override
	public EnumSpellType getSpellType() 
	{
		return EnumSpellType.FRONT;
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