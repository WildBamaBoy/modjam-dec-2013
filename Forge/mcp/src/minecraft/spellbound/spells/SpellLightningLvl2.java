package spellbound.spells;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import spellbound.core.PacketHandler;
import spellbound.entity.EntityTargetSpell;
import spellbound.enums.EnumSpellType;
import cpw.mods.fml.common.network.PacketDispatcher;

public class SpellLightningLvl2 extends AbstractSpell
{
	@Override
	public String getSpellDisplayName() 
	{
		return "Lightning Bolt";
	}

	@Override
	public void doSpellCasterEffect(EntityPlayer caster) 
	{
		if (!caster.worldObj.isRemote)
		{
			caster.inventory.consumeInventoryItem(caster.inventory.currentItem);
			caster.worldObj.playSoundAtEntity(caster, "mob.ghast.fireball", 1.0F, 1.0F);
			caster.worldObj.spawnEntityInWorld(new EntityTargetSpell(caster.worldObj, this));
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
		double spawnX = entityHit != null ? entityHit.posX : posX;
		double spawnY = entityHit != null ? entityHit.posY : posY;
		double spawnZ = entityHit != null ? entityHit.posZ : posZ;
		
		EntityLightningBolt lightning = new EntityLightningBolt(worldObj, spawnX, spawnY, spawnZ);
		worldObj.spawnEntityInWorld(lightning);
		
		PacketDispatcher.sendPacketToAllPlayers(PacketHandler.createLightningPacket(spawnX, spawnY, spawnZ));
	}
}
