package spellbound.spells;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import spellbound.enums.EnumSpellType;

public class SpellMinorScrying extends AbstractSpell
{
	@Override
	public String getSpellDisplayName() 
	{
		return "Minor Scrying";
	}

	@Override
	public void doSpellCasterEffect(EntityPlayer caster) 
	{
		
	}

	@Override
	public EnumSpellType getSpellType() 
	{
		return EnumSpellType.SELF;
	}

	@Override
	public void doSpellTargetEffect(World worldObj, int posX, int posY, int posZ, EntityLivingBase entityHit) {
		// TODO Auto-generated method stub
		
	}
}
