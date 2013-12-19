/**********************************************
 * SpellWallOfBedrock.java
 * Copyright (c) 2013 Wild Bama Boy.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl.html
 **********************************************/

package spellbound.spells;

import spellbound.core.SpellboundCore;
import spellbound.enums.EnumItemInUseTime;

public class SpellWallOfBedrock extends AbstractSpellWall
{
	@Override
	public String getSpellDisplayName() 
	{
		return "Wall of Bedrock";
	}

	@Override
	public int getWallBlockId() 
	{
		return SpellboundCore.getInstance().blockFalseBedrock.blockID;
	}
	
	@Override
	public EnumItemInUseTime getSpellCastDuration() 
	{
		return EnumItemInUseTime.FOUR_SECONDS;
	}
}
