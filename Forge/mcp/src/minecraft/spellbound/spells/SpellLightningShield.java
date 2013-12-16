package spellbound.spells;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import spellbound.core.SpellboundCore;
import spellbound.core.SpellEntry;
import spellbound.enums.EnumSpellType;

public class SpellLightningShield extends AbstractSpell
{
	@Override
	public String getSpellDisplayName() 
	{
		return "Lightning Shield";
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
		// TODO Auto-generated method stub
		
	}
}
