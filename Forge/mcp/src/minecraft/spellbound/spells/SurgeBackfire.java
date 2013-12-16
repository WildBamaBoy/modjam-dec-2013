package spellbound.spells;

import net.minecraft.entity.player.EntityPlayer;

public class SurgeBackfire extends AbstractSurge
{
	@Override
	public String getSpellDisplayName() 
	{
		return "Backfire";
	}

	@Override
	public void doSpellCasterEffect(EntityPlayer caster) 
	{
		caster.setFire(10);
	}
}
