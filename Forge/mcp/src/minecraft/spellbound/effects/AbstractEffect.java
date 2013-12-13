package spellbound.effects;

import net.minecraft.entity.player.EntityPlayer;
import spellbound.enums.EnumSpellType;

public abstract class AbstractEffect 
{
	public EntityPlayer caster;
	
	public abstract String getSpellDisplayName();
	
	public abstract void doSpellEffect(EntityPlayer caster);
	
	public abstract void updateSpellEffect();
	
	public abstract EnumSpellType getSpellType();
}
