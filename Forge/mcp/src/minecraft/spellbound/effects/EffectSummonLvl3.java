package spellbound.effects;

import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import spellbound.core.SB;
import spellbound.enums.EnumSpellType;

public class EffectSummonLvl3 extends AbstractEffect
{
	@Override
	public String getSpellDisplayName() 
	{
		return "Summon Invisible Warrior";
	}

	@Override
	public void doSpellEffect(EntityPlayer caster) 
	{
		if (!caster.worldObj.isRemote)
		{
//			EntityInvisibleWarrior warrior = new EntityInvisibleWarrior();
//			warrior.setPosition(caster.posX, caster.posY, caster.posZ);
//			caster.worldObj.spawnEntityInWorld(warrior);
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
	public void doSpellTargetEffect(World worldObj, int posX, int posY, int posZ) {
		// TODO Auto-generated method stub
		
	}
}
