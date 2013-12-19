/**********************************************
 * BlockMushroomRedOrange.java
 * Copyright (c) 2013 Wild Bama Boy.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl.html
 **********************************************/

package spellbound.blocks;

import spellbound.core.SpellboundCore;
import spellbound.spells.AbstractSpell;

public class BlockMushroomRedOrange extends AbstractMushroom
{
	public BlockMushroomRedOrange(int itemId) 
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
		this.setUnlocalizedName("RED ORANGE PRIMARY");
	}

	@Override
	public void setTexture() 
	{
		this.setTextureName("spellbound:mushroom_redorange");
	}

	@Override
	public int[] getMateIds() 
	{
		return new int[]
				{
				SpellboundCore.getInstance().blockHybridMushroomYellow.blockID,
				SpellboundCore.getInstance().blockPrimaryMushroomPinkOrange.blockID
				};
	}

	@Override
	public int getOffspringId(int mateId) 
	{
		if (mateId == SpellboundCore.getInstance().blockHybridMushroomYellow.blockID)
		{
			return SpellboundCore.getInstance().blockHybridMushroomRainbow.blockID;
		}
		
		else if (mateId == SpellboundCore.getInstance().blockPrimaryMushroomPinkOrange.blockID)
		{
			return SpellboundCore.modRandom.nextBoolean() ? SpellboundCore.getInstance().blockHybridMushroomOrange.blockID : SpellboundCore.getInstance().blockHybridMushroomWhite.blockID;
		}
		
		else
		{
			return -1;
		}
	}
}
