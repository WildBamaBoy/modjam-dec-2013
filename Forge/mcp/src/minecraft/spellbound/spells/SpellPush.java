package spellbound.spells;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import spellbound.enums.EnumItemInUseTime;
import spellbound.enums.EnumSpellType;

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
		int radius = 10;
		
		for (Object obj : caster.worldObj.getEntitiesWithinAABBExcludingEntity(caster, AxisAlignedBB.getBoundingBox(caster.posX - radius, caster.posY - 3, caster.posZ - radius, caster.posX + radius, caster.posY + 3, caster.posZ + radius)))
		{
			if (obj instanceof EntityLivingBase)
			{
				EntityLivingBase entity = (EntityLivingBase)obj;
				entity.attackEntityFrom(DamageSource.causeIndirectMagicDamage(caster, entity), 0.0F);
				
				double d0 = entity.posX - caster.posX;
                double d1;

                for (d1 = entity.posZ - caster.posZ; d0 * d0 + d1 * d1 < 1.0E-4D; d1 = (Math.random() - Math.random()) * 0.01D)
                {
                    d0 = (Math.random() - Math.random()) * 0.01D;
                }
                
                for (int i = 0; i < 10; i++)
                {
                	entity.knockBack(caster, 10.0F, d0 * -1, d1 * -1);
                }
			}
		}
	}
	
	@Override
	public EnumSpellType getSpellType() 
	{
		return EnumSpellType.AREA;
	}

	@Override
	public void doSpellTargetEffect(World worldObj, int posX, int posY, int posZ, EntityLivingBase entityHit) 
	{
	}
	
	@Override
	public EnumItemInUseTime getSpellCastDuration() 
	{
		return EnumItemInUseTime.ONE_SECOND;
	}
}
