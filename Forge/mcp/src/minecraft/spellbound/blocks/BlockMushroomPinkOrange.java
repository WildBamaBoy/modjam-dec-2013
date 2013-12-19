/**********************************************
 * BlockMushroomPinkOrange.java
 * Copyright (c) 2013 Wild Bama Boy.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl.html
 **********************************************/

package spellbound.blocks;

import spellbound.core.SpellboundCore;
import spellbound.spells.AbstractSpell;

public class BlockMushroomPinkOrange extends AbstractMushroom
{
	public BlockMushroomPinkOrange(int itemId) 
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
		this.setUnlocalizedName("Pink ORANGE PRIMARY");
	}

	@Override
	public void setTexture() 
	{
		this.setTextureName("spellbound:mushroom_pinkorange");
	}

	@Override
	public int[] getMateIds() 
	{
		return new int[]
				{
				SpellboundCore.getInstance().blockPrimaryMushroomRedOrange.blockID
				};
	}

	@Override
	public int getOffspringId(int mateId) 
	{
		if (mateId == SpellboundCore.getInstance().blockPrimaryMushroomRedOrange.blockID)
		{
			return SpellboundCore.modRandom.nextBoolean() ? SpellboundCore.getInstance().blockHybridMushroomWhite.blockID : SpellboundCore.getInstance().blockHybridMushroomOrange.blockID;
		}
		
		else
		{
			return -1;
		}
	}	
}
