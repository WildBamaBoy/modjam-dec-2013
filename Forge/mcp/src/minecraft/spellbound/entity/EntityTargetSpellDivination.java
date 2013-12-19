/**********************************************
 * EntityTargetSpellDivination.java
 * Copyright (c) 2013 Wild Bama Boy.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl.html
 **********************************************/

package spellbound.entity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import spellbound.spells.AbstractSpell;

public class EntityTargetSpellDivination extends AbstractTargetSpell
{
	public EntityTargetSpellDivination(World worldObj)
	{
		super(worldObj);
	}
	
	public EntityTargetSpellDivination(EntityPlayer player, AbstractSpell spell)
	{
		super(player, spell);
	}
}
