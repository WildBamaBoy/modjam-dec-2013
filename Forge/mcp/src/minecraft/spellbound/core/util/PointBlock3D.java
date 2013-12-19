/**********************************************
 * PointBlock3D.java
 * Copyright (c) 2013 Wild Bama Boy.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl.html
 **********************************************/

package spellbound.core.util;

public class PointBlock3D 
{
	public int posX;
	public int posY;
	public int posZ;
	public int blockId;
	
	public PointBlock3D(int posX, int posY, int posZ, int blockId)
	{
		this.posX = posX;
		this.posY = posY;
		this.posZ = posZ;
		this.blockId = blockId;
	}
}
