package spellbound.effects;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import spellbound.enums.EnumSpellType;

public abstract class AbstractEffect 
{
	public EntityPlayer caster;
	
	public abstract String getSpellDisplayName();
	
	public abstract void doSpellEffect(EntityPlayer caster);
	
	public abstract void doSpellTargetEffect(World worldObj, int posX, int posY, int posZ, EntityLivingBase entityHit);
	
	public abstract void updateSpellEffect();
	
	public abstract EnumSpellType getSpellType();
}
