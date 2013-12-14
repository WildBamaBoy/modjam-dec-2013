package spellbound.effects;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import spellbound.enums.EnumSpellType;

public class EffectFishForm extends AbstractEffect
{
	@Override
	public String getSpellDisplayName() 
	{
		return "Fish Form";
	}

	@Override
	public void doSpellEffect(EntityPlayer caster) 
	{
		caster.addPotionEffect(new PotionEffect(Potion.waterBreathing.id, 1200));
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
	public void doSpellTargetEffect(World worldObj, int posX, int posY, int posZ, EntityLivingBase entityHit) {
		// TODO Auto-generated method stub
		
	}
}
