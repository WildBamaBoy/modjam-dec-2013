package spellbound.effects;

import spellbound.enums.EnumSpellType;
import net.minecraft.entity.player.EntityPlayer;

public abstract class AbstractEffect 
{
	public EntityPlayer caster;
	
	public abstract String getSpellDisplayName();
	
	public abstract void doSpellEffect();
	
	public abstract void updateSpellEffect();
	
	public abstract EnumSpellType getSpellType();
}
