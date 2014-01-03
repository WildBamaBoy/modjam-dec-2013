package spellbound.spells;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import spellbound.core.SpellboundCore;
import spellbound.core.forge.PacketHandler;
import spellbound.entity.EntityMeteor;
import spellbound.entity.EntityTargetSpellFire;
import spellbound.enums.EnumItemInUseTime;
import spellbound.enums.EnumSpellRange;
import cpw.mods.fml.common.network.PacketDispatcher;

public class SpellMeteor extends AbstractSpell
{
	@Override
	public String getSpellDisplayName() 
	{
		return "Meteor";
	}

	@Override
	public EnumItemInUseTime getSpellCastDuration() 
	{
		return EnumItemInUseTime.FIVE_SECONDS;
	}

	@Override
	public void doSpellCasterEffect(EntityPlayer caster) 
	{
		caster.worldObj.playSoundAtEntity(caster, "mob.ghast.fireball", 1.0F, 1.0F);
		caster.worldObj.spawnEntityInWorld(new EntityTargetSpellFire(caster, this));
	}

	@Override
	public void doSpellTargetEffect(World worldObj, int posX, int posY, int posZ, EntityLivingBase entityHit) 
	{
		for (int i = 0; i < 3; i++)
		{
			final double nextX = SpellboundCore.modRandom.nextBoolean() ? SpellboundCore.modRandom.nextInt(15) + 10 : SpellboundCore.modRandom.nextInt(15) + 10 * -1;
			final double nextZ = SpellboundCore.modRandom.nextBoolean() ? SpellboundCore.modRandom.nextInt(15) + 10 : SpellboundCore.modRandom.nextInt(15) + 10 * -1;
			
			worldObj.spawnEntityInWorld(new EntityLightningBolt(worldObj, posX + nextX, posY, posZ + nextZ));
			PacketDispatcher.sendPacketToAllPlayers(PacketHandler.createLightningPacket(posX + nextX, posY, posZ + nextZ));
		}
		
		final EntityMeteor meteor = new EntityMeteor(caster, this);
		meteor.setPosition(posX + SpellboundCore.modRandom.nextGaussian(), 255, posZ + SpellboundCore.modRandom.nextGaussian());
		worldObj.spawnEntityInWorld(meteor);
	}

	@Override
	public EnumSpellRange getSpellType() 
	{
		return EnumSpellRange.TARGET;
	}
}
