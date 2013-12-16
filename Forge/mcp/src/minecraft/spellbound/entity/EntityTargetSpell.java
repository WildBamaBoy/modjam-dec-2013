package spellbound.entity;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityFireball;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import spellbound.spells.AbstractSpell;

public class EntityTargetSpell extends EntityFireball
{
	private final AbstractSpell spell;
	
	public EntityTargetSpell(EntityPlayer player, AbstractSpell spell) 
	{
		super(player.worldObj);
		
		final Vec3 vec = player.getLookVec();
		
		this.spell = spell;
		this.setPosition(player.posX + vec.xCoord * 5, player.posY + 1 + vec.yCoord * 5, player.posZ + vec.zCoord * 5);
		this.accelerationX = vec.xCoord * 0.3;
		this.accelerationY = vec.yCoord * 0.3;
		this.accelerationZ = vec.zCoord * 0.3;
	}

	@Override
	protected void onImpact(MovingObjectPosition pos) 
	{
		if (pos.entityHit != null && pos.entityHit instanceof EntityLivingBase)
		{
			spell.doSpellTargetEffect(worldObj, pos.blockX, pos.blockY, pos.blockZ, (EntityLivingBase)pos.entityHit);
		}
		
		else
		{
			spell.doSpellTargetEffect(worldObj, pos.blockX, pos.blockY, pos.blockZ, null);
		}
		
		setDead();
	}
}
