package spellbound.entity;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityFireball;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import spellbound.effects.AbstractEffect;

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
		if (pos.entityHit != null && pos.entityHit instanceof EntityLivingBase)
		{
			effect.doSpellTargetEffect(worldObj, pos.blockX, pos.blockY, pos.blockZ, (EntityLivingBase)pos.entityHit);
		}
		
		else
		{
			effect.doSpellTargetEffect(worldObj, pos.blockX, pos.blockY, pos.blockZ, null);
		}
		setDead();
	}
}
