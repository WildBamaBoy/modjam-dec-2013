package spellbound.spells;

import spellbound.core.SpellboundCore;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class SurgeRiches extends AbstractSurge
{
	@Override
	public String getSpellDisplayName() 
	{
		return "Unimaginable Riches";
	}

	@Override
	public void doSpellCasterEffect(EntityPlayer caster) 
	{
		for (int i = 0; i < caster.inventory.mainInventory.length; i++)
		{
			if (SpellboundCore.rand.nextBoolean() && SpellboundCore.rand.nextBoolean() && SpellboundCore.rand.nextBoolean())
			{
				caster.inventory.setInventorySlotContents(i, new ItemStack(Item.ingotGold));
			}
		}

		for (int i = 0; i < 3; i++)
		{
			if (caster.inventory.armorInventory[i] != null)
			{
				if (i == 3)
				{
					caster.inventory.armorInventory[i] = new ItemStack(Item.helmetGold);
				}

				else if (i == 2)
				{
					caster.inventory.armorInventory[i] = new ItemStack(Item.plateGold);	
				}

				else if (i == 1)
				{
					caster.inventory.armorInventory[i] = new ItemStack(Item.legsGold);
				}

				else if (i == 0)
				{
					caster.inventory.armorInventory[i] = new ItemStack(Item.bootsGold);
				}
			}
		}
	}
}
