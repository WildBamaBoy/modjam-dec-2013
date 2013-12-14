package spellbound.effects;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityFireball;
import net.minecraft.entity.projectile.EntityLargeFireball;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import spellbound.core.SB;
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

        fireball.setLocationAndAngles(caster.posX, caster.posY + (double)caster.getEyeHeight(), caster.posZ, caster.rotationYaw, caster.rotationPitch);
        
        fireball.posX -= (double)(MathHelper.cos(caster.rotationYaw / 180.0F * (float)Math.PI) * 0.16F);
        fireball.posY -= 0.10000000149011612D;
        fireball.posZ -= (double)(MathHelper.sin(caster.rotationYaw / 180.0F * (float)Math.PI) * 0.16F);
        
        fireball.setPosition(fireball.posX, fireball.posY, fireball.posZ);
        
        fireball.yOffset = 0.0F;
        
        fireball.motionX = (double)(-MathHelper.sin(caster.rotationYaw / 180.0F * (float)Math.PI) * MathHelper.cos(caster.rotationPitch / 180.0F * (float)Math.PI));
        fireball.motionY = (double)(-MathHelper.sin(caster.rotationPitch / 180.0F * (float)Math.PI));
        fireball.motionZ = (double)(MathHelper.cos(caster.rotationYaw / 180.0F * (float)Math.PI) * MathHelper.cos(caster.rotationPitch / 180.0F * (float)Math.PI));
        
        setThrowableHeading(fireball, fireball.motionX, fireball.motionY, fireball.motionZ, 1.0F * 1.5F, 1.0F);
        
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
	
    /**
     * Similar to setArrowHeading, it's point the throwable entity to a x, y, z direction.
     */
    public void setThrowableHeading(EntityFireball fireball, double par1, double par3, double par5, float par7, float par8)
    {
        float f2 = MathHelper.sqrt_double(par1 * par1 + par3 * par3 + par5 * par5);
        par1 /= (double)f2;
        par3 /= (double)f2;
        par5 /= (double)f2;
        par1 += SB.rand.nextGaussian() * (double)(SB.rand.nextBoolean() ? -1 : 1) * 0.007499999832361937D * (double)par8;
        par3 += SB.rand.nextGaussian() * (double)(SB.rand.nextBoolean() ? -1 : 1) * 0.007499999832361937D * (double)par8;
        par5 += SB.rand.nextGaussian() * (double)(SB.rand.nextBoolean() ? -1 : 1) * 0.007499999832361937D * (double)par8;
        par1 *= (double)par7;
        par3 *= (double)par7;
        par5 *= (double)par7;
        fireball.motionX = par1;
        fireball.motionY = par3;
        fireball.motionZ = par5;
        float f3 = MathHelper.sqrt_double(par1 * par1 + par5 * par5);
        fireball.prevRotationYaw = fireball.rotationYaw = (float)(Math.atan2(par1, par5) * 180.0D / Math.PI);
        fireball.prevRotationPitch = fireball.rotationPitch = (float)(Math.atan2(par3, (double)f3) * 180.0D / Math.PI);
    }
}
