package spellbound.effects;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityLargeFireball;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import spellbound.enums.EnumSpellType;

public class EffectFireLvl2 extends AbstractEffect
{
	@Override
	public String getSpellDisplayName() 
	{
		return "Fireball";
	}

	@Override
	public void doSpellEffect(EntityPlayer caster) 
	{
		caster.inventory.consumeInventoryItem(caster.inventory.currentItem);
		caster.worldObj.playSoundAtEntity(caster, "mob.ghast.fireball", 1.0F, 1.0F);
		
        EntityLargeFireball fireball = new EntityLargeFireball(caster.worldObj, caster, caster.posX, caster.posY, caster.posZ);

        fireball.shootingEntity = caster;

        fireball.posY = caster.posY + (double)caster.getEyeHeight() - 0.10000000149011612D;
        double d0 = caster.posX - caster.posX;
        double d1 = caster.boundingBox.minY + (double)(caster.height / 3.0F) - fireball.posY;
        double d2 = caster.posZ - caster.posZ * 4;
        double d3 = (double)MathHelper.sqrt_double(d0 * d0 + d2 * d2);
        
        caster.worldObj.spawnEntityInWorld(fireball);
	}

	@Override
	public void updateSpellEffect() 
	{
		
	}
	
	@Override
	public EnumSpellType getSpellType() 
	{
		return EnumSpellType.TARGET;
	}
}
