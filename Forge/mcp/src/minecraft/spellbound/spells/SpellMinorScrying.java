package spellbound.spells;

import net.minecraft.entity.player.EntityPlayer;
import spellbound.core.SpellboundCore;
import spellbound.entity.EntityAllSeeingEye;
import spellbound.enums.EnumItemInUseTime;
import spellbound.enums.EnumSpellType;

public class SpellMinorScrying extends AbstractSpellScrying
{
	@Override
	public String getSpellDisplayName() 
	{
		return "Minor Scrying";
	}

	@Override
	public void doSpellCasterEffect(EntityPlayer caster) 
	{
		if (!caster.worldObj.isRemote)
		{
			this.eye = new EntityAllSeeingEye(caster.worldObj, caster.posX, caster.posY, caster.posZ);
			eye.setPosition(caster.posX, caster.posY, caster.posZ);
			caster.worldObj.spawnEntityInWorld(eye);
			SpellboundCore.instance.addActiveSpellToPlayer(caster, this, 100);
		}
	}

	@Override
	public EnumSpellType getSpellType() 
	{
		return EnumSpellType.SELF;
	}

	@Override
	public EnumItemInUseTime getSpellDuration() 
	{
		return EnumItemInUseTime.ONE_SECOND;
	}
}
