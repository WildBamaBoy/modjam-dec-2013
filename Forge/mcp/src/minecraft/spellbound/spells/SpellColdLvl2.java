package spellbound.spells;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import spellbound.core.Logic;
import spellbound.entity.EntityTargetSpell;
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
		if (!caster.worldObj.isRemote)
		{
			caster.inventory.consumeInventoryItem(caster.inventory.currentItem);
			caster.worldObj.playSoundAtEntity(caster, "mob.ghast.fireball", 1.0F, 1.0F);

			Vec3 vec = caster.getLookVec();
			EntityTargetSpell spell = new EntityTargetSpell(caster.worldObj, this);
			spell.setPosition(caster.posX + vec.xCoord * 5, caster.posY + 1 + vec.yCoord * 5, caster.posZ + vec.zCoord * 5);

			spell.accelerationX = vec.xCoord * 0.3;
			spell.accelerationY = vec.yCoord * 0.3;
			spell.accelerationZ = vec.zCoord * 0.3;

			caster.worldObj.spawnEntityInWorld(spell);
		}
	}

	@Override
	public void updateSpellSpell() 
	{

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
			for (Coordinates c : Logic.getNearbyBlocks(worldObj, (int)entityHit.posX, (int)entityHit.posY, (int)entityHit.posZ, 3, new int[]{Block.grass.blockID, Block.dirt.blockID, Block.sand.blockID, Block.stone.blockID, Block.cobblestone.blockID}))
			{
				if (worldObj.getBlockId(c.x, c.y + 1, c.z) == 0)
				{
					worldObj.setBlock(c.x, c.y + 1, c.z, Block.snow.blockID);
				}
			}
			
			entityHit.attackEntityFrom(DamageSource.magic, 5.0F);
			entityHit.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 1200));
		}
	}
}
