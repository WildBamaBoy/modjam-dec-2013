package spellbound.effects;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import spellbound.enums.EnumSpellType;

public class EffectUltimateElementalFury extends AbstractEffect 
{
	@Override
	public String getSpellDisplayName() 
	{
		return "Elemental Fury";
	}

	@Override
	public void doSpellEffect(EntityPlayer caster) {
		// TODO Auto-generated method stub
		
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
	public void doSpellTargetEffect(World worldObj, int posX, int posY, int posZ) {
		// TODO Auto-generated method stub
		
	}
}
