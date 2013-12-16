package spellbound.spells;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.World;
import spellbound.entity.EntityAllSeeingEye;
import spellbound.enums.EnumSpellType;

public abstract class AbstractSpellScrying extends AbstractSpell
{
	public EntityAllSeeingEye eye;
	
	@Override
	public void doSpellTargetEffect(World worldObj, int posX, int posY, int posZ, EntityLivingBase entityHit) 
	{
		//No target effect.
	}

	@Override
	public EnumSpellType getSpellType() 
	{
		return EnumSpellType.SELF;
	}

}
