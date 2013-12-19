/**********************************************
 * BlockMushroomOrangeGrey.java
 * Copyright (c) 2013 Wild Bama Boy.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl.html
 **********************************************/

package spellbound.blocks;

import spellbound.core.SpellboundCore;
import spellbound.spells.AbstractSpell;

public class BlockMushroomOrangeGrey extends AbstractMushroom
{
	public BlockMushroomOrangeGrey(int itemId) 
	{
		super(itemId);
	}

	@Override
	public AbstractSpell getMushroomSpell() 
	{
		return null;
	}

	@Override
	public void setName() 
	{
		this.setUnlocalizedName("Orange Grey HYBRID");
	}

	@Override
	public void setTexture() 
	{
		this.setTextureName("spellbound:mushroom_orangegrey");
	}

	@Override
	public int[] getMateIds() 
	{
		return new int[]
				{
				SpellboundCore.getInstance().blockPrimaryMushroomBlueGrey.blockID
				};
	}

	@Override
	public int getOffspringId(int mateId)
	{
		if (mateId == SpellboundCore.getInstance().blockPrimaryMushroomBlueGrey.blockID)
		{
			return SpellboundCore.modRandom.nextBoolean() ? SpellboundCore.getInstance().blockHybridMushroomLightBlue.blockID : SpellboundCore.getInstance().blockHybridMushroomGrey.blockID;
		}
		
		else
		{
			return -1;
		}
	}
}
