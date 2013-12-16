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
import spellbound.enums.EnumItemInUseTime;
import spellbound.enums.EnumSpellType;

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
			caster.inventory.consumeInventoryItem(caster.inventory.currentItem);
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
								if (obj instanceof EntityLivingBase)
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
	public EnumSpellType getSpellType() 
	{
		return EnumSpellType.FRONT;
	}

	@Override
	public void doSpellTargetEffect(World worldObj, int posX, int posY, int posZ, EntityLivingBase entityHit) 
	{
	}
	
	@Override
	public EnumItemInUseTime getSpellDuration() 
	{
		return EnumItemInUseTime.THREE_SECONDS;
	}
}
