package spellbound.entity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import spellbound.spells.AbstractSpell;

public class EntityTargetSpellMundane extends AbstractTargetSpell
{
	public EntityTargetSpellMundane(World worldObj)
	{
		super(worldObj);
	}
	
	public EntityTargetSpellMundane(EntityPlayer player, AbstractSpell spell)
	{
		super(player, spell);
	}
}
