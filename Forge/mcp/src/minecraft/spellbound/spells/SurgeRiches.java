/**********************************************
 * SurgeRiches.java
 * Copyright (c) 2013 Wild Bama Boy.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl.html
 **********************************************/

package spellbound.spells;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import spellbound.core.SpellboundCore;

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
			if (SpellboundCore.modRandom.nextBoolean() && SpellboundCore.modRandom.nextBoolean() && SpellboundCore.modRandom.nextBoolean())
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
