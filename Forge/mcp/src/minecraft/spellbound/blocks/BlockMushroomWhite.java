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
				SpellboundCore.getInstance().blockHybridMushroomWhite.blockID,
				SpellboundCore.getInstance().blockHybridMushroomOrangeGrey.blockID, //Orange + BlueGrey
				SpellboundCore.getInstance().blockHybridMushroomLightBlue.blockID, //GreyOrange + BlueGrey //COLD!
				SpellboundCore.getInstance().blockHybridMushroomGrey.blockID, //GreyOrange + BlueGrey >>>Also
				SpellboundCore.getInstance().blockHybridMushroomYellow.blockID, //OrangeGrey + Grey //LIGHTNING!
				SpellboundCore.getInstance().blockHybridMushroomRainbow.blockID, //Red Orange + Yellow //RANDOM! //2nd LEVEL
				SpellboundCore.getInstance().blockHybridMushroomGold.blockID, //Rainbow + Yellow //2nd level
				SpellboundCore.getInstance().blockHybridMushroomBlack.blockID, //Blue Grey + Grey //2nd level
				SpellboundCore.getInstance().blockHybridMushroomPurple.blockID
				};
	}

	@Override
	public int getOffspringId(int mateId) 
	{
		return mateId;
	}
}
