package spellbound.spells;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import spellbound.entity.EntityTargetSpell;
import spellbound.enums.EnumSpellType;

public class SpellLightningLvl1 extends AbstractSpell
{
	@Override
	public String getSpellDisplayName() 
	{
		return "Tazer";
	}

	@Override
	public void doSpellCasterEffect(EntityPlayer caster) 
	{
		if (!caster.worldObj.isRemote)
		{
			caster.inventory.consumeInventoryItem(caster.inventory.currentItem);
			caster.worldObj.playSoundAtEntity(caster, "mob.ghast.fireball", 1.0F, 1.0F);
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
			entityHit.attackEntityFrom(DamageSource.magic, 5.0F);
			entityHit.addPotionEffect(new PotionEffect(Potion.confusion.id, 1200));
		}
	}
}
