package spellbound.spells;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import spellbound.enums.EnumItemInUseTime;
import spellbound.enums.EnumSpellRange;

public class SpellPush extends AbstractSpell
{
	@Override
	public String getSpellDisplayName() 
	{
		return "Push";
	}

	@Override
	public void doSpellCasterEffect(EntityPlayer caster) 
	{
		final int radius = 10;
		
		caster.worldObj.playSoundAtEntity(caster, "mob.enderdragon.wings", 1.0F, 1.0F);
		
		for (final Object obj : caster.worldObj.getEntitiesWithinAABBExcludingEntity(caster, AxisAlignedBB.getBoundingBox(caster.posX - radius, caster.posY - 3, caster.posZ - radius, caster.posX + radius, caster.posY + 3, caster.posZ + radius)))
		{
			if (obj instanceof EntityLivingBase)
			{
				final EntityLivingBase entity = (EntityLivingBase)obj;
				entity.attackEntityFrom(DamageSource.causeIndirectMagicDamage(caster, entity), 0.0F);
				
				double deltaX = entity.posX - caster.posX;
                double deltaZ;

                for (deltaZ = entity.posZ - caster.posZ; deltaX * deltaX + deltaZ * deltaZ < 1.0E-4D; deltaZ = (Math.random() - Math.random()) * 0.01D)
                {
                    deltaX = (Math.random() - Math.random()) * 0.01D;
                }
                
                for (int i = 0; i < 10; i++)
                {
                	entity.knockBack(caster, 10.0F, deltaX * -1, deltaZ * -1);
                }
			}
		}
	}
	
	@Override
	public EnumSpellRange getSpellType() 
	{
		return EnumSpellRange.AREA;
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
