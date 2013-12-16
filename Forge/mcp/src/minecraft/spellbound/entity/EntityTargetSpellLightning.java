package spellbound.entity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import spellbound.spells.AbstractSpell;

public class EntityTargetSpellLightning extends AbstractTargetSpell
{
	public EntityTargetSpellLightning(World worldObj)
	{
		super(worldObj);
	}
	
	public EntityTargetSpellLightning(EntityPlayer player, AbstractSpell spell) 
	{
		super(player, spell);
	}
}
