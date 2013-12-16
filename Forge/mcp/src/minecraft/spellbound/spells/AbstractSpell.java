package spellbound.spells;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import spellbound.enums.EnumSpellType;

public abstract class AbstractSpell 
{
	public EntityPlayer caster;
	
	public boolean doMagicSurge()
	{
		//TODO
		return false;
	}
	
	public abstract String getSpellDisplayName();
	
	public abstract void doSpellCasterEffect(EntityPlayer caster);
	
	public abstract void doSpellTargetEffect(World worldObj, int posX, int posY, int posZ, EntityLivingBase entityHit);
	
	public abstract EnumSpellType getSpellType();
}
