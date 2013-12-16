package spellbound.spells;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import spellbound.core.Constants;
import spellbound.core.Logic;
import spellbound.core.SpellboundCore;
import spellbound.entity.EntityTargetSpellCold;
import spellbound.enums.EnumItemInUseTime;
import spellbound.enums.EnumSpellType;
import spellbound.util.Coordinates;

public class SpellColdLvl2 extends AbstractSpell
{
	@Override
	public String getSpellDisplayName() 
	{
		return "Icicle";
	}

	@Override
	public void doSpellCasterEffect(EntityPlayer caster) 
	{
		caster.worldObj.playSoundAtEntity(caster, "mob.ghast.fireball", 1.0F, 1.0F);

		if (!caster.worldObj.isRemote)
		{
			caster.worldObj.spawnEntityInWorld(new EntityTargetSpellCold(caster, this));
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
		if (entityHit != null)
		{
			for (final Coordinates c : Logic.getNearbyBlocks(worldObj, (int)entityHit.posX, (int)entityHit.posY, (int)entityHit.posZ, 3, Constants.BLOCKS_SUPPORTING_SNOW))
			{
				if (worldObj.getBlockId(c.x, c.y + 1, c.z) == 0)
				{
					worldObj.setBlock(c.x, c.y + 1, c.z, Block.snow.blockID);
				}
			}

			if (!(entityHit instanceof EntityPlayer))
			{
				entityHit.attackEntityFrom(DamageSource.magic, 5.0F);
				entityHit.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 1200));
			}

			else
			{
				if (!SpellboundCore.instance.playerHasActiveSpell((EntityPlayer)entityHit, "SpellShieldOfInvulnerability") && !SpellboundCore.instance.playerHasActiveSpell((EntityPlayer)entityHit, "SpellColdShield"))
				{							
					entityHit.attackEntityFrom(DamageSource.magic, 5.0F);
					entityHit.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 1200));
				}
			}
		}
	}

	@Override
	public EnumItemInUseTime getSpellCastDuration() 
	{
		return EnumItemInUseTime.TWO_SECONDS;
	}
}
