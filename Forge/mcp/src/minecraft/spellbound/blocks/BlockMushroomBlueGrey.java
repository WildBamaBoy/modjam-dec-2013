/**********************************************
 * BlockMushroomBlueGrey.java
 * Copyright (c) 2013 Wild Bama Boy.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl.html
 **********************************************/

package spellbound.blocks;

import spellbound.core.SpellboundCore;
import spellbound.spells.AbstractSpell;

public class BlockMushroomBlueGrey extends AbstractMushroom
{
	public BlockMushroomBlueGrey(int itemId) 
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
		this.setUnlocalizedName("BLUEGREYPRIMARY");
	}

	@Override
	public void setTexture() 
	{
		this.setTextureName("spellbound:mushroom_bluegrey");
	}

	@Override
	public int[] getMateIds() 
	{
		//Grey, GreyOrange, Orange
		return new int[]
				{
				SpellboundCore.getInstance().blockHybridMushroomGrey.blockID, 
				SpellboundCore.getInstance().blockHybridMushroomOrangeGrey.blockID, 
				SpellboundCore.getInstance().blockHybridMushroomOrange.blockID
				};
	}

	@Override
	public int getOffspringId(int mateId) 
	{
		if (mateId == SpellboundCore.getInstance().blockHybridMushroomGrey.blockID)
		{
			return SpellboundCore.getInstance().blockHybridMushroomBlack.blockID;
		}
		
		else if (mateId == SpellboundCore.getInstance().blockHybridMushroomOrangeGrey.blockID)
		{
			return SpellboundCore.modRandom.nextBoolean() ? SpellboundCore.getInstance().blockHybridMushroomGrey.blockID : SpellboundCore.getInstance().blockHybridMushroomLightBlue.blockID;
		}
		
		else if (mateId == SpellboundCore.getInstance().blockHybridMushroomOrange.blockID)
		{
			return SpellboundCore.getInstance().blockHybridMushroomOrangeGrey.blockID;
		}
		
		else
		{
			return -1;
		}
	}
}
