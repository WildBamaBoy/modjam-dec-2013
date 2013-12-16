package spellbound.spells;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import spellbound.core.SpellEntry;
import spellbound.core.SpellboundCore;
import spellbound.enums.EnumSpellType;

public abstract class AbstractSpellShield extends AbstractSpell
{
	@Override
	public final void doSpellCasterEffect(EntityPlayer caster) 
	{
		this.caster = caster;

		List<SpellEntry> activeSpellsForCaster = SpellboundCore.activeSpells.get(caster);

		if (activeSpellsForCaster == null)
		{
			List<SpellEntry> entryList = new ArrayList<SpellEntry>();
			entryList.add(new SpellEntry(this, getShieldDuration()));
			SpellboundCore.activeSpells.put(caster, entryList);
		}

		else
		{
			activeSpellsForCaster.add(new SpellEntry(this, getShieldDuration()));
			SpellboundCore.activeSpells.put(caster, activeSpellsForCaster);
		}
	}

	@Override
	public final void doSpellTargetEffect(World worldObj, int posX, int posY, int posZ, EntityLivingBase entityHit) 
	{
		//No target effect.
	}

	@Override
	public final EnumSpellType getSpellType() 
	{
		return EnumSpellType.SELF;
	}

	public abstract int getShieldDuration();
}
