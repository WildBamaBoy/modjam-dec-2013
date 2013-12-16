package spellbound.spells;

import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import spellbound.enums.EnumItemInUseTime;
import spellbound.enums.EnumSpellType;

public class SpellWailOfTheBanshee extends AbstractSpell
{
	@Override
	public String getSpellDisplayName() 
	{
		return "Wail of the Banshee";
	}

	@Override
	public void doSpellCasterEffect(EntityPlayer caster) 
	{
		caster.inventory.consumeInventoryItem(caster.inventory.currentItem);

		caster.worldObj.playSoundAtEntity(caster, "mob.wither.idle", 1.0F, 1.0F);
		caster.worldObj.playSoundAtEntity(caster, "spellbound:banshee", 1.0F, 1.0F);

		final List<Entity> entitiesInArea = caster.worldObj.getEntitiesWithinAABBExcludingEntity(caster, AxisAlignedBB.getBoundingBox(caster.posX - 20, caster.posY - 20, caster.posZ - 20, caster.posX + 20, caster.posY + 20, caster.posZ + 20));
		
		for (final Entity entity : entitiesInArea)
		{
			//TODO Chance of surviving
			if (entity instanceof EntityLivingBase)
			{
				entity.attackEntityFrom(DamageSource.magic, 50.0F);
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
		//No target effect.
	}
	
	@Override
	public EnumItemInUseTime getSpellCastDuration() 
	{
		return EnumItemInUseTime.FIVE_SECONDS;
	}
}
