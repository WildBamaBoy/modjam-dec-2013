package spellbound.spells;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import spellbound.core.SpellboundCore;
import spellbound.entity.EntityTargetSpellDisruption;
import spellbound.enums.EnumItemInUseTime;
import spellbound.enums.EnumSpellType;

public class SpellChaos extends AbstractSpell
{
	@Override
	public String getSpellDisplayName() 
	{
		return "Chaos";
	}

	@Override
	public void doSpellCasterEffect(EntityPlayer caster) 
	{
		caster.worldObj.playSoundAtEntity(caster, "mob.ghast.fireball", 1.0F, 1.0F);
		caster.worldObj.spawnEntityInWorld(new EntityTargetSpellDisruption(caster, this));
	}

	@Override
	public EnumSpellType getSpellType() 
	{
		return EnumSpellType.TARGET;
	}

	@Override
	public void doSpellTargetEffect(World worldObj, int posX, int posY, int posZ, EntityLivingBase entityHit) 
	{
		if (entityHit != null && entityHit instanceof EntityPlayer)
		{
			if (!SpellboundCore.instance.playerHasActiveSpell((EntityPlayer)entityHit, "SpellShieldOfInvulnerability"))
			{
				SpellboundCore.instance.addActiveSpellToPlayer(caster, this, 200);
			}
		}
	}

	@Override
	public EnumItemInUseTime getSpellCastDuration() 
	{
		return EnumItemInUseTime.FOUR_SECONDS;
	}
}
