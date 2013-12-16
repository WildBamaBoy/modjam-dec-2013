package spellbound.entity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import spellbound.spells.AbstractSpell;

public class EntityTargetSpellDisruption extends AbstractTargetSpell
{
	public EntityTargetSpellDisruption(World worldObj)
	{
		super(worldObj);
	}
	
	public EntityTargetSpellDisruption(EntityPlayer player, AbstractSpell spell) 
	{
		super(player, spell);
	}
}
