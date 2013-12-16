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

public class SpellSurgeShield extends AbstractSpellShield
{
	@Override
	public String getSpellDisplayName() 
	{
		return "Surge Shield";
	}

	@Override
	public int getShieldDuration() 
	{
		return 1200;
	}

	@Override
	public EnumItemInUseTime getSpellCastDuration() 
	{
		return EnumItemInUseTime.ONE_SECOND;
	}
}
