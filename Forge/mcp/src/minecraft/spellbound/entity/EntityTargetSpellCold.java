package spellbound.entity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import spellbound.spells.AbstractSpell;

public class EntityTargetSpellCold extends AbstractTargetSpell
{
	public EntityTargetSpellCold(World worldObj)
	{
		super(worldObj);
	}
	
	public EntityTargetSpellCold(EntityPlayer player, AbstractSpell spell) 
	{
		super(player, spell);
	}
}
