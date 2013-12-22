/**********************************************
 * BlockMushroomWhite.java
 * Copyright (c) 2013 Wild Bama Boy.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl.html
 **********************************************/

package spellbound.blocks;

import spellbound.core.SpellboundCore;
import spellbound.spells.AbstractSpell;

public class BlockMushroomWhite extends AbstractMushroom
{
	public BlockMushroomWhite(int itemId) 
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
		this.setUnlocalizedName("WHITE HYBRID");
	}

	@Override
	public void setTexture() 
	{
		this.setTextureName("spellbound:mushroom_white");
	}

	@Override
	public int[] getMateIds() 
	{
		return new int[]
				{
				SpellboundCore.getInstance().blockHybridMushroomBlack.blockID,
				SpellboundCore.getInstance().blockHybridMushroomOrange.blockID,
				SpellboundCore.getInstance().blockHybridMushroomOrangeGrey.blockID,
				SpellboundCore.getInstance().blockHybridMushroomLightBlue.blockID,
				SpellboundCore.getInstance().blockHybridMushroomGrey.blockID,
				SpellboundCore.getInstance().blockHybridMushroomYellow.blockID,
				SpellboundCore.getInstance().blockHybridMushroomRainbow.blockID,
				SpellboundCore.getInstance().blockHybridMushroomGold.blockID,
				SpellboundCore.getInstance().blockHybridMushroomBlack.blockID,
				SpellboundCore.getInstance().blockHybridMushroomPurple.blockID
				};
	}

	@Override
	public int getOffspringId(int mateId) 
	{
		return mateId;
	}
}
