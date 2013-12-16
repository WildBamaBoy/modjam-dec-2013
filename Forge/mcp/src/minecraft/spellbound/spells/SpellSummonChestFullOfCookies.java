package spellbound.spells;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import spellbound.core.Logic;
import spellbound.core.SpellboundCore;
import spellbound.enums.EnumSpellType;
import spellbound.util.Coordinates;

public class SpellSummonChestFullOfCookies extends AbstractSpell 
{
	@Override
	public String getSpellDisplayName() 
	{
		return "Summon Chest Full of Cookies";
	}

	@Override
	public void doSpellCasterEffect(EntityPlayer caster) 
	{
		caster.worldObj.playSoundAtEntity(caster, "random.burp", 1.0F, 1.0F);

		if (!caster.worldObj.isRemote)
		{
			for (Coordinates c : Logic.getNearbyBlocks(caster.worldObj, (int)caster.posX, (int)caster.posY, (int)caster.posZ, 5, 0))
			{
				if (caster.worldObj.getBlockId(c.x, c.y - 1, c.z) != 0 && SpellboundCore.rand.nextBoolean()) 
				{
					caster.worldObj.setBlock(c.x, c.y, c.z, Block.chest.blockID);
					IInventory inventory = Block.chest.getInventory(caster.worldObj, c.x, c.y, c.z);
					
					for (int i = 0; i < inventory.getSizeInventory(); i++)
					{
						inventory.setInventorySlotContents(i, new ItemStack(Item.cookie, 64, 0));
					}
					
					break;
				}
			}
		}
	}

	@Override
	public void doSpellTargetEffect(World worldObj, int posX, int posY, int posZ, EntityLivingBase entityHit) 
	{

	}

	@Override
	public EnumSpellType getSpellType() 
	{
		return EnumSpellType.SELF;
	}
}
