package spellbound.effects;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import spellbound.enums.EnumSpellType;

public class EffectHaste extends AbstractEffect
{
	@Override
	public String getSpellDisplayName() 
	{
		return "Haste";
	}

	@Override
	public void doSpellEffect(EntityPlayer caster) 
	{
		caster.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 1200));
		caster.addPotionEffect(new PotionEffect(Potion.digSpeed.id, 1200));
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
