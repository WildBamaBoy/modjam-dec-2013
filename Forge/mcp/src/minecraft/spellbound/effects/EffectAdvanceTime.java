package spellbound.effects;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import spellbound.core.SB;
import spellbound.enums.EnumSpellType;

public class EffectAdvanceTime extends AbstractEffect
{
	@Override
	public String getSpellDisplayName() 
	{
		return "Advance Time";
	}

	@Override
	public void doSpellEffect(EntityPlayer caster) 
	{
		long newWorldTime = caster.worldObj.getWorldTime() + (SB.rand.nextInt(5000) + 5000);
		caster.worldObj.setWorldTime(newWorldTime);
	}

	@Override
	public void updateSpellEffect() 
	{
		
	}
	
	@Override
	public EnumSpellType getSpellType() 
	{
		return EnumSpellType.SELF;
	}

	@Override
	public void doSpellTargetEffect(World worldObj, int posX, int posY, int posZ) {
		// TODO Auto-generated method stub
		
	}
}
