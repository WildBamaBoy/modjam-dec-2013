package spellbound.spells;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import spellbound.core.SpellboundCore;
import spellbound.enums.EnumItemInUseTime;
import spellbound.enums.EnumSpellType;

public class SpellSummonLvl2 extends AbstractSpell
{
	@Override
	public String getSpellDisplayName() 
	{
		return "Summon Mob";
	}

	@Override
	public void doSpellCasterEffect(EntityPlayer caster) 
	{
		if (!caster.worldObj.isRemote)
		{
			EntityMob mob = SpellboundCore.rand.nextBoolean() ? new EntitySkeleton(caster.worldObj) : new EntityZombie(caster.worldObj);
			mob.setPosition(caster.posX, caster.posY, caster.posZ);
			caster.worldObj.spawnEntityInWorld(mob);
		}
	}
	
	@Override
	public EnumSpellType getSpellType() 
	{
		return EnumSpellType.SELF;
	}

	@Override
	public void doSpellTargetEffect(World worldObj, int posX, int posY, int posZ, EntityLivingBase entityHit) {
	}
	
	@Override
	public EnumItemInUseTime getSpellCastDuration() 
	{
		return EnumItemInUseTime.TWO_SECONDS;
	}
}
