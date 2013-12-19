/**********************************************
 * BlockMushroomGrey.java
 * Copyright (c) 2013 Wild Bama Boy.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl.html
 **********************************************/

package spellbound.blocks;

import spellbound.core.SpellboundCore;
import spellbound.spells.AbstractSpell;

public class BlockMushroomGrey extends AbstractMushroom
{
	public BlockMushroomGrey(int itemId) 
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
		this.setUnlocalizedName("GREY HYBRID");
	}

	@Override
	public void setTexture() 
	{
		this.setTextureName("spellbound:mushroom_grey");
	}

	@Override
	public int[] getMateIds() 
	{
		return new int[]
				{
			SpellboundCore.getInstance().blockHybridMushroomOrangeGrey.blockID,
			SpellboundCore.getInstance().blockPrimaryMushroomBlueGrey.blockID,
			SpellboundCore.getInstance().blockHybridMushroomRainbow.blockID
				};
	}

	@Override
	public int getOffspringId(int mateId) 
	{
		if (mateId == SpellboundCore.getInstance().blockHybridMushroomOrangeGrey.blockID)
		{
			return SpellboundCore.getInstance().blockHybridMushroomYellow.blockID;
		}
		
		else if (mateId == SpellboundCore.getInstance().blockPrimaryMushroomBlueGrey.blockID)
		{
			return SpellboundCore.getInstance().blockHybridMushroomBlack.blockID;
		}
		
		else if (mateId == SpellboundCore.getInstance().blockHybridMushroomRainbow.blockID)
		{
			return SpellboundCore.getInstance().blockHybridMushroomPurple.blockID;
		}
		
		else
		{
			return -1;
		}
	}
}
