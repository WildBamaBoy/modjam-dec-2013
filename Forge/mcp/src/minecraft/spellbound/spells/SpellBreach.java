package spellbound.spells;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import spellbound.core.SpellboundCore;
import spellbound.entity.EntityTargetSpellMundane;
import spellbound.enums.EnumItemInUseTime;
import spellbound.enums.EnumSpellType;

public class SpellBreach extends AbstractSpell
{
	@Override
	public String getSpellDisplayName() 
	{
		return "Breach";
	}

	@Override
	public void doSpellCasterEffect(EntityPlayer caster) 
	{
		if (!caster.worldObj.isRemote)
		{
			caster.inventory.consumeInventoryItem(caster.inventory.currentItem);
			caster.worldObj.playSoundAtEntity(caster, "mob.ghast.fireball", 1.0F, 1.0F);
			caster.worldObj.spawnEntityInWorld(new EntityTargetSpellMundane(caster, this));
		}
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
			SpellboundCore.instance.removeActiveSpellFromPlayer((EntityPlayer) entityHit, "SpellFireShield");
			SpellboundCore.instance.removeActiveSpellFromPlayer((EntityPlayer) entityHit, "SpellColdShield");
			SpellboundCore.instance.removeActiveSpellFromPlayer((EntityPlayer) entityHit, "SpellLightningShield");
			SpellboundCore.instance.removeActiveSpellFromPlayer((EntityPlayer) entityHit, "SpellSurgeShield");
		}
	}

	@Override
	public EnumItemInUseTime getSpellCastDuration() 
	{
		return EnumItemInUseTime.TWO_SECONDS;
	}
}
