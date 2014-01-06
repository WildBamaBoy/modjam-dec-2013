package spellbound.entity;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import spellbound.core.SpellboundCore;
import spellbound.core.util.Logic;
import spellbound.core.util.Point3D;
import spellbound.spells.AbstractSpell;

public class EntityMeteor extends AbstractTargetSpell
{
	public boolean playedEffect;

	public EntityMeteor(World worldObj)
	{
		super(worldObj);
		this.setSize(10.0F, 10.0F);
	}

	public EntityMeteor(EntityPlayer player, AbstractSpell spell) 
	{
		super(player, spell);
		this.setSize(10.0F, 10.0F);
	}

	@Override
	public void onUpdate() 
	{
		super.onUpdate();

		if (!playedEffect)
		{
			this.worldObj.playSoundEffect(this.posX, this.posY, this.posZ, "spellbound:meteor", 10000.0F, 0.8F + this.rand.nextFloat() * 0.2F);
			playedEffect = true;
		}

		if (this.ticksExisted < 120)
		{
			this.accelerationX = 0;
			this.accelerationY = 0;
			this.accelerationZ = 0;
			this.motionX = 0;
			this.motionY = 0;
			this.motionZ = 0;
		}

		if (this.ticksExisted == 120 && !worldObj.isRemote)
		{
			this.accelerationY = -0.5F;
			this.setFire(60);
		}
	}

	@Override
	protected String getDisplayParticle() 
	{
		return "flame";
	}

	@Override
	protected void onImpact(MovingObjectPosition pos) 
	{
		//Spell will be null when exiting while spell is in progress.
		if (!worldObj.isRemote && spell != null)
		{
			worldObj.createExplosion(caster, posX, posY, posZ, 30.0F, SpellboundCore.getInstance().propertiesManager.propertiesList.doAllowSpellGreifing);

			if (SpellboundCore.getInstance().propertiesManager.propertiesList.doAllowSpellGreifing)
			{
				for (final Point3D point : Logic.getNearbyBlocksForMeteorHeat(worldObj, (int)posX, (int)posY, (int)posZ, 30, 10, -10, 0))
				{
					if (SpellboundCore.modRandom.nextBoolean() && SpellboundCore.modRandom.nextBoolean())
					{
						worldObj.setBlock(point.posX, point.posY, point.posZ, Block.fire.blockID);
					}
				}
			}
		}

		setDead();
	}
}
