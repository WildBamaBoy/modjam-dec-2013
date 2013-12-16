package spellbound.spells;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.World;
import spellbound.enums.EnumItemInUseTime;
import spellbound.enums.EnumSpellType;

public abstract class AbstractSurge extends AbstractSpell
{
	@Override
	public final EnumItemInUseTime getSpellCastDuration() 
	{
		return EnumItemInUseTime.INSTANT;
	}

	@Override
	public final void doSpellTargetEffect(World worldObj, int posX, int posY, int posZ, EntityLivingBase entityHit) 
	{
		//No target effect.
	}

	@Override
	public final EnumSpellType getSpellType() 
	{
		return EnumSpellType.SELF;
	}
}
