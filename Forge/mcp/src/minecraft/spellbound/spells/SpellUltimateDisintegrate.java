package spellbound.spells;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import spellbound.core.SpellboundCore;
import spellbound.entity.EntityTargetSpell;
import spellbound.enums.EnumSpellType;

public class SpellUltimateDisintegrate extends AbstractSpell
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
			caster.inventory.consumeInventoryItem(caster.inventory.currentItem);
			caster.worldObj.playSoundAtEntity(caster, "mob.wither.spawn", 1.0F, 1.0F);

			Vec3 vec = caster.getLookVec();
			EntityTargetSpell spell = new EntityTargetSpell(caster.worldObj, this);
			spell.setPosition(caster.posX + vec.xCoord * 5, caster.posY + 1 + vec.yCoord * 5, caster.posZ + vec.zCoord * 5);

			spell.accelerationX = vec.xCoord * 0.3;
			spell.accelerationY = vec.yCoord * 0.3;
			spell.accelerationZ = vec.zCoord * 0.3;

			caster.worldObj.spawnEntityInWorld(spell);
		}
	}

	@Override
	public void updateSpellSpell() {
		// TODO Auto-generated method stub

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
}
