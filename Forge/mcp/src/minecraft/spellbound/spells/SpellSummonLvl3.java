package spellbound.spells;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import spellbound.enums.EnumItemInUseTime;
import spellbound.enums.EnumSpellType;

public class SpellSummonLvl3 extends AbstractSpell
{
	@Override
	public String getSpellDisplayName() 
	{
		return "Summon Invisible Warrior";
	}

	@Override
	public void doSpellCasterEffect(EntityPlayer caster) 
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
	public EnumSpellType getSpellType() 
	{
		return EnumSpellType.SELF;
	}

	@Override
	public void doSpellTargetEffect(World worldObj, int posX, int posY, int posZ, EntityLivingBase entityHit) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public EnumItemInUseTime getSpellDuration() 
	{
		return EnumItemInUseTime.THREE_SECONDS;
	}
}
