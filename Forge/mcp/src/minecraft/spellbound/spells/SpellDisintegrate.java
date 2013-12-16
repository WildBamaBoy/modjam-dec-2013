package spellbound.spells;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import spellbound.core.SpellboundCore;
import spellbound.entity.EntityTargetSpell;
import spellbound.enums.EnumItemInUseTime;
import spellbound.enums.EnumSpellType;

public class SpellDisintegrate extends AbstractSpell
{
	@Override
	public String getSpellDisplayName()
	{
		return "Disintegrate";
	}

	@Override
	public void doSpellCasterEffect(EntityPlayer caster) 
	{
		if (!caster.worldObj.isRemote)
		{
			caster.worldObj.spawnEntityInWorld(new EntityTargetSpell(caster, this));
		}
	}

	@Override
	public EnumSpellType getSpellType() 
	{
		return EnumSpellType.TARGET;
	}

	@Override
	public void doSpellTargetEffect(World worldObj, int posX, int posY, int posZ, EntityLivingBase entityHit) 
	{
		if (entityHit != null)
		{
			if (SpellboundCore.rand.nextBoolean())
			{
				entityHit.setDead();
				
				EntityItem item = new EntityItem(worldObj, entityHit.posX, entityHit.posY, entityHit.posZ, new ItemStack(Item.dyePowder, 1, 15));
				worldObj.spawnEntityInWorld(item);
			}
			
			else
			{
				entityHit.setFire(10);
				entityHit.attackEntityFrom(DamageSource.magic, 10.0F);
			}
		}
	}
	
	@Override
	public EnumItemInUseTime getSpellDuration() 
	{
		return EnumItemInUseTime.FIVE_SECONDS;
	}
}
