/**********************************************
 * SpellEntry.java
 * Copyright (c) 2013 Wild Bama Boy.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl.html
 **********************************************/

package spellbound.core.util;

import spellbound.spells.AbstractSpell;

public class SpellEntry 
{
	public AbstractSpell spell;
	public int durationCounter;
	public int maxDuration;
	
	public SpellEntry(AbstractSpell spell, int maxDuration)
	{
		this.spell = spell;
		this.maxDuration = maxDuration;
	}
}
