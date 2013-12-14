package spellbound.effects;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import spellbound.enums.EnumSpellType;

public class EffectSummonLvl1 extends AbstractEffect
{
	@Override
	public String getSpellDisplayName() 
	{
		return "Summon Wolf";
	}

	@Override
	public void doSpellEffect(EntityPlayer caster) 
	{
		if (!caster.worldObj.isRemote)
		{
			EntityWolf wolf = new EntityWolf(caster.worldObj);
			
			wolf.setAngry(true);
			wolf.setPosition(caster.posX, caster.posY, caster.posZ);
			caster.worldObj.spawnEntityInWorld(wolf);
		}
		
		//TODO Particles
	}

	@Override
	public void updateSpellEffect() 
	{
		
	}
	
	@Override
	public EnumSpellType getSpellType() 
	{
		return EnumSpellType.SELF;
	}

	@Override
	public void doSpellTargetEffect(World worldObj, int posX, int posY, int posZ, EntityLivingBase entityHit); {
		// TODO Auto-generated method stub
		
	}
}
