package spellbound.spells;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import spellbound.entity.EntityTargetSpellMundane;
import spellbound.enums.EnumItemInUseTime;
import spellbound.enums.EnumSpellRange;

public class SpellTorchlight extends AbstractSpell
{
	@Override
	public String getSpellDisplayName() 
	{
		return "Torchlight";
	}

	@Override
	public EnumItemInUseTime getSpellCastDuration() 
	{
		return EnumItemInUseTime.INSTANT;
	}

	@Override
	public void doSpellCasterEffect(EntityPlayer caster) 
	{
		caster.worldObj.playSoundAtEntity(caster, "mob.ghast.fireball", 1.0F, 1.0F);
		caster.worldObj.spawnEntityInWorld(new EntityTargetSpellMundane(caster, this));
	}

	@Override
	public void doSpellTargetEffect(World worldObj, int posX, int posY, int posZ, EntityLivingBase entityHit) 
	{
		for (int movY = 0; movY < 2; movY++)
		{
			for (int movX = -1; movX < 2; movX++)
			{
				for (int movZ = -1; movZ < 2; movZ++)
				{
					if (worldObj.getBlockId(posX + movX, posY + movY, posZ + movZ) == 0)
					{
						worldObj.setBlock(posX + movX, posY + movY, posZ + movZ, Block.torchWood.blockID);
						return;
					}
				}
			}
		}
	}

	@Override
	public EnumSpellRange getSpellType() 
	{
		return EnumSpellRange.TARGET;
	}
}
