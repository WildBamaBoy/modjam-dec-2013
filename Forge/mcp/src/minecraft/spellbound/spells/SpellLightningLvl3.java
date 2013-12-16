package spellbound.spells;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import spellbound.enums.EnumItemInUseTime;
import spellbound.enums.EnumSpellType;

public class SpellLightningLvl3 extends AbstractSpell
{
	@Override
	public String getSpellDisplayName() 
	{
		return "Summon Storm";
	}

	@Override
	public void doSpellCasterEffect(EntityPlayer caster) 
	{
		
	}
	
	@Override
	public EnumSpellType getSpellType() 
	{
		return EnumSpellType.AREA;
	}

	@Override
	public void doSpellTargetEffect(World worldObj, int posX, int posY, int posZ, EntityLivingBase entityHit) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public EnumItemInUseTime getSpellDuration() 
	{
		return EnumItemInUseTime.THREE_SECONDS;
	}
}
