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
		return "Summon Wither Skeleton";
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
	}

	@Override
	public EnumSpellType getSpellType() 
	{
		return EnumSpellType.SELF;
	}

	@Override
	public void doSpellTargetEffect(World worldObj, int posX, int posY, int posZ, EntityLivingBase entityHit) 
	{
		//No target effect.
	}
	
	@Override
	public EnumItemInUseTime getSpellCastDuration() 
	{
		return EnumItemInUseTime.THREE_SECONDS;
	}
}
