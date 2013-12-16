package spellbound.spells;

import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.player.EntityPlayer;

public class SurgeCow extends AbstractSurge
{
	@Override
	public String getSpellDisplayName() 
	{
		return "...Cow?";
	}

	@Override
	public void doSpellCasterEffect(EntityPlayer caster) 
	{
		EntityCow cow = new EntityCow(caster.worldObj);
		cow.setPosition(caster.posX, caster.posY, caster.posZ);
		caster.worldObj.spawnEntityInWorld(cow);
	}
}
