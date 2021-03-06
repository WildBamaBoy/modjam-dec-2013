/**********************************************
 * BlockMushroomPurple.java
 * Copyright (c) 2013 Wild Bama Boy.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl.html
 **********************************************/

package spellbound.blocks;

import spellbound.spells.AbstractSpell;

public class BlockMushroomPurple extends AbstractMushroom
{
	public BlockMushroomPurple(int itemId) 
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
		this.setUnlocalizedName("PURPLE HYBRID");
	}

	@Override
	public void setTexture() 
	{
		this.setTextureName("spellbound:mushroom_purple");
	}

	@Override
	public int[] getMateIds() 
	{
		return new int[0];
	}

	@Override
	public int getOffspringId(int mateId) 
	{
		return -1;
	}
}
