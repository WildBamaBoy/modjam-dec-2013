package spellbound.spells;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import spellbound.enums.EnumItemInUseTime;
import spellbound.enums.EnumSpellType;

public abstract class AbstractSpell 
{
	public EntityPlayer caster;

	public String getSpellChargeSound()
	{
		switch (getSpellCastDuration())
		{
		case INSTANT: return "null";
		case ONE_SECOND: return "spellbound:spellcharge1second";
		case TWO_SECONDS: return "spellbound:spellcharge2seconds";
		case THREE_SECONDS: return "spellbound:spellcharge3seconds";
		case FOUR_SECONDS: return "spellbound:spellcharge4seconds";
		case FIVE_SECONDS: return "spellbound:spellcharge5seconds";
		default: return "spellbound:spellcharge5seconds";
		}
	}
	
	public boolean doMagicSurge()
	{
		return false;
	}

	public abstract String getSpellDisplayName();
	
	public abstract EnumItemInUseTime getSpellCastDuration();

	public abstract void doSpellCasterEffect(EntityPlayer caster);

	public abstract void doSpellTargetEffect(World worldObj, int posX, int posY, int posZ, EntityLivingBase entityHit);
	
	public abstract EnumSpellType getSpellType();
}
