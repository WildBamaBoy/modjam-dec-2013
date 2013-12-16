package spellbound.entity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import spellbound.spells.AbstractSpell;

public class EntityTargetSpellFire extends AbstractTargetSpell
{
	public EntityTargetSpellFire(World worldObj)
	{
		super(worldObj);
	}
	
	public EntityTargetSpellFire(EntityPlayer player, AbstractSpell spell)
	{
		super(player, spell);
	}
}
