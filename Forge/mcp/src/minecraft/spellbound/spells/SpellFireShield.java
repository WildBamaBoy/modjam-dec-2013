package spellbound.spells;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import spellbound.core.SpellEntry;
import spellbound.core.SpellboundCore;
import spellbound.enums.EnumItemInUseTime;
import spellbound.enums.EnumSpellType;

public class SpellFireShield extends AbstractSpell
{
	@Override
	public String getSpellDisplayName() 
	{
		return "Fire Shield";
	}

	@Override
	public void doSpellCasterEffect(EntityPlayer caster) 
	{
		if (!caster.worldObj.isRemote)
		{
			this.caster = caster;

			List<SpellEntry> activeSpellsForCaster = SpellboundCore.activeSpells.get(caster);

			if (activeSpellsForCaster == null)
			{
				List<SpellEntry> entryList = new ArrayList<SpellEntry>();
				entryList.add(new SpellEntry(this, 1200));
				SpellboundCore.activeSpells.put(caster, entryList);
			}

			else
			{
				activeSpellsForCaster.add(new SpellEntry(this, 1200));
				SpellboundCore.activeSpells.put(caster, activeSpellsForCaster);
			}
		}
	}

	@Override
	public EnumSpellType getSpellType() 
	{
		return EnumSpellType.SELF;
	}

	@Override
	public void doSpellTargetEffect(World worldObj, int posX, int posY, int posZ, EntityLivingBase entityHit) {
	}
	
	@Override
	public EnumItemInUseTime getSpellDuration() 
	{
		return EnumItemInUseTime.ONE_SECOND;
	}
}
