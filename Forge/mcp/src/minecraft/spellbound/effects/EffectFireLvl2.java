package spellbound.effects;

import java.util.Random;

import net.minecraft.block.BlockDispenser;
import net.minecraft.dispenser.IPosition;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityLargeFireball;
import net.minecraft.entity.projectile.EntitySmallFireball;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
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
		
		//EntityLargeFireball fireball = new EntityLargeFireball(caster.worldObj, caster, caster.posX, caster.posY, caster.posZ);
        
		EnumFacing enumfacing = BlockDispenser.getFacing(1);
        double d0 = caster.posX;
        double d1 = caster.posY + 2;
        double d2 = caster.posZ;
        World world = caster.worldObj;
        Random random = world.rand;
        double d3 = caster.posX; //random.nextGaussian() * 0.05D + (double)enumfacing.getFrontOffsetX();
        double d4 = caster.posY + 10; //random.nextGaussian() * 0.05D + (double)enumfacing.getFrontOffsetY();
        double d5 = caster.posZ; //random.nextGaussian() * 0.05D + (double)enumfacing.getFrontOffsetZ();
        world.spawnEntityInWorld(new EntitySmallFireball(world, d0, d1, d2, d3, d4, d5));
        
//        caster.worldObj.spawnEntityInWorld(fireball);
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
