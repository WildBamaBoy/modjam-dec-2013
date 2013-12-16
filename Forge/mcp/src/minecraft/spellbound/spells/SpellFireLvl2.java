package spellbound.spells;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityLargeFireball;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import spellbound.enums.EnumItemInUseTime;
import spellbound.enums.EnumSpellType;

public class SpellFireLvl2 extends AbstractSpell
{
	@Override
	public String getSpellDisplayName() 
	{
		return "Fireball";
	}

	@Override
	public void doSpellCasterEffect(EntityPlayer caster) 
	{
		caster.worldObj.playSoundAtEntity(caster, "mob.ghast.fireball", 1.0F, 1.0F);
		
		if (!caster.worldObj.isRemote)
		{
			Vec3 vec = caster.getLookVec();
			EntityLargeFireball fireball = new EntityLargeFireball(caster.worldObj, caster, caster.posX, caster.posY, caster.posZ);
			fireball.setPosition(caster.posX + vec.xCoord * 5, caster.posY + 1 + vec.yCoord * 5, caster.posZ + vec.zCoord * 5);

			fireball.accelerationX = vec.xCoord * 0.3;
			fireball.accelerationY = vec.yCoord * 0.3;
			fireball.accelerationZ = vec.zCoord * 0.3;

			caster.worldObj.spawnEntityInWorld(fireball);
		}
	}

	@Override
	public EnumSpellType getSpellType() 
	{
		return EnumSpellType.TARGET;
	}

	@Override
	public void doSpellTargetEffect(World worldObj, int posX, int posY, int posZ, EntityLivingBase entityHit) {
		// TODO Auto-generated method stub

	}
	
	@Override
	public EnumItemInUseTime getSpellCastDuration() 
	{
		return EnumItemInUseTime.TWO_SECONDS;
	}
}
