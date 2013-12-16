package spellbound.entity;

import spellbound.spells.AbstractSpell;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class EntityTargetSpellDivination extends AbstractTargetSpell
{
	public EntityTargetSpellDivination(World worldObj)
	{
		super(worldObj);
	}
	
	public EntityTargetSpellDivination(EntityPlayer player, AbstractSpell spell)
	{
		super(player, spell);
	}
}
