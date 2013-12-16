package spellbound.spells;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import spellbound.core.Constants;
import spellbound.core.Logic;
import spellbound.core.SpellboundCore;
import spellbound.enums.EnumSpellType;
import spellbound.util.Coordinates;

public class SpellAdvanceTime extends AbstractSpell
{
	@Override
	public String getSpellDisplayName() 
	{
		return "Advance Time";
	}

	@Override
	public void doSpellCasterEffect(EntityPlayer caster) 
	{
		if (!caster.worldObj.isRemote)
		{
			final long newWorldTime = caster.worldObj.getWorldTime() + SpellboundCore.rand.nextInt(5000) + 5000;
			caster.worldObj.setWorldTime(newWorldTime);

			for (final int cropID : Constants.CROP_IDS)
			{
				for (final Coordinates c : Logic.getNearbyBlocks(caster.worldObj, (int)caster.posX, (int)caster.posY, (int)caster.posZ, Constants.RADIUS_ADVANCETIME, cropID))
				{
					caster.worldObj.setBlockMetadataWithNotify(c.x, c.y, c.z, 7, 2);
				}
			}
		}
	}

	@Override
	public EnumSpellType getSpellType() 
	{
		return EnumSpellType.SELF;
	}

	@Override
	public void doSpellTargetEffect(World worldObj, int posX, int posY, int posZ, EntityLivingBase entityHit) 
	{
		//No target effect.
	}
}
