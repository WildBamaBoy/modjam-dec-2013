package spellbound.entity;

import spellbound.effects.AbstractEffect;
import net.minecraft.entity.projectile.EntityFireball;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityTargetSpell extends EntityFireball
{
	private AbstractEffect effect;
	
	public EntityTargetSpell(World par1World, AbstractEffect effect) 
	{
		super(par1World);
		this.effect = effect;
	}

	@Override
	protected void onImpact(MovingObjectPosition pos) 
	{
		effect.doSpellTargetEffect(worldObj, pos.blockX, pos.blockY, pos.blockZ, pos.entityHit);
		setDead();
	}
}
