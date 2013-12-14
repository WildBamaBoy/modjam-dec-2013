package spellbound.effects;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import spellbound.entity.EntityTargetSpell;
import spellbound.enums.EnumSpellType;

public class EffectUltimateElementalFury extends AbstractEffect 
{
	@Override
	public String getSpellDisplayName() 
	{
		return "Elemental Fury";
	}

	@Override
	public void doSpellEffect(EntityPlayer caster) 
	{
		caster.worldObj.playSoundAtEntity(caster, "mob.wither.spawn", 1.0F, 1.0F);
		caster.worldObj.playSoundAtEntity(caster, "ambient.weather.thunder", 1.0F, 1.0F);
		
		Vec3 vec = caster.getLookVec();
		EntityTargetSpell spell = new EntityTargetSpell(caster.worldObj, this);
		spell.setPosition(caster.posX + vec.xCoord * 5, caster.posY + 1 + vec.yCoord * 5, caster.posZ + vec.zCoord * 5);
		
		spell.accelerationX = vec.xCoord * 0.3;
		spell.accelerationY = vec.yCoord * 0.3;
		spell.accelerationZ = vec.zCoord * 0.3;
		
		if (!caster.worldObj.isRemote)
		{
			caster.worldObj.spawnEntityInWorld(spell);
		}
	}

	@Override
	public void updateSpellEffect() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public EnumSpellType getSpellType() 
	{
		return EnumSpellType.FRONT;
	}

	@Override
	public void doSpellTargetEffect(World worldObj, int posX, int posY, int posZ, EntityLivingBase entityHit); 
	{
		int radius = 3;
		
		System.out.println(posX + "," + posY + "," + posZ);
		for (Object obj : worldObj.getEntitiesWithinAABB(EntityLivingBase.class, AxisAlignedBB.getBoundingBox(posX - radius, posY - radius, posZ - radius, posX + radius, posY + radius, posZ + radius)))
		{
			EntityLivingBase livingEntity = (EntityLivingBase)obj;
			livingEntity.motionY += 5.0D;
			System.out.println("A");
		}
	}
}
