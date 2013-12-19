/**********************************************
 * Logic.java
 * Copyright (c) 2013 Wild Bama Boy.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl.html
 **********************************************/

package spellbound.core.util;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import spellbound.blocks.AbstractMushroom;

public final class Logic 
{
	public static Point3DBlock getNearbyMushroomMate(AbstractMushroom mushroom, World worldObj, int startX, int startY, int startZ, int maxDistanceAway, int[] searchIds)
	{
		int movementX = 0 - maxDistanceAway;
		int movementY = 1;
		int movementZ = 0 - maxDistanceAway;

		while (true)
		{
			final int pointX = startX + movementX;
			final int pointY = startY + movementY;
			final int pointZ = startZ + movementZ;
			final int blockId = worldObj.getBlockId(pointX, pointY, pointZ);

			for (final int foundId : searchIds)
			{
				if (blockId == foundId && worldObj.getBlockId(pointX, pointY + 1, pointZ) == 0)
				{
					return new Point3DBlock(pointX, pointY + 1, pointZ, mushroom.getOffspringId(foundId));
				}
			}

			if (movementX == maxDistanceAway && movementZ == maxDistanceAway && movementY == -1)
			{
				//Will be done. None will be found.
				return null;
			}

			if (movementX == maxDistanceAway && movementZ == maxDistanceAway)
			{
				//Reset for next level
				movementX = 0 - maxDistanceAway;
				movementY--;
				movementZ = 0 - maxDistanceAway;

				continue;
			}

			if (movementX == maxDistanceAway)
			{
				movementX = 0 - maxDistanceAway;
				movementZ++;
				continue;
			}

			movementX++;
		}
	}

	public static Point3DBlock getNearbyMushroomSpawn(World worldObj, int startX, int startY, int startZ, int maxDistanceAway)
	{
		int movementX = 0 - maxDistanceAway;
		int movementY = 1;
		int movementZ = 0 - maxDistanceAway;

		while (true)
		{
			final int pointX = startX + movementX;
			final int pointY = startY + movementY;
			final int pointZ = startZ + movementZ;
			final int blockId = worldObj.getBlockId(pointX, pointY, pointZ);

			if ((blockId == Block.grass.blockID || blockId == Block.dirt.blockID) && worldObj.getBlockId(pointX, pointY + 1, pointZ) == 0)
			{
				return new Point3DBlock(pointX, pointY + 1, pointZ, blockId);
			}

			if (movementX == maxDistanceAway && movementZ == maxDistanceAway && movementY == -1)
			{
				//Will be done. None will be found.
				return null;
			}

			if (movementX == maxDistanceAway && movementZ == maxDistanceAway)
			{
				//Reset for next level
				movementX = 0 - maxDistanceAway;
				movementY--;
				movementZ = 0 - maxDistanceAway;

				continue;
			}

			if (movementX == maxDistanceAway)
			{
				movementX = 0 - maxDistanceAway;
				movementZ++;
				continue;
			}

			movementX++;
		}
	}

	public static List<Point3D> getNearbyBlocks(World worldObj, int startX, int startY, int startZ, int maxDistanceAway, int searchId)
	{
		final List<Point3D> returnList = new ArrayList<Point3D>();
		int movementX = 0 - maxDistanceAway;
		int movementY = 3;
		int movementZ = 0 - maxDistanceAway;

		while (true)
		{
			final int pointX = startX + movementX;
			final int pointY = startY + movementY;
			final int pointZ = startZ + movementZ;
			final int blockId = worldObj.getBlockId(pointX, pointY, pointZ);

			if (blockId == searchId)
			{
				returnList.add(new Point3D(pointX, pointY, pointZ));
			}

			if (movementX == maxDistanceAway && movementZ == maxDistanceAway && movementY == -1)
			{
				break;
			}

			if (movementX == maxDistanceAway && movementZ == maxDistanceAway)
			{
				//Reset for next level
				movementX = 0 - maxDistanceAway;
				movementY--;
				movementZ = 0 - maxDistanceAway;

				continue;
			}

			if (movementX == maxDistanceAway)
			{
				movementX = 0 - maxDistanceAway;
				movementZ++;
				continue;
			}

			movementX++;
		}

		return returnList;
	}

	public static List<Point3D> getNearbyBlocks(World worldObj, int startX, int startY, int startZ, int maxDistanceAway, int[] searchIDs)
	{
		final List<Point3D> returnList = new ArrayList<Point3D>();
		int movementX = 0 - maxDistanceAway;
		int movementY = 3;
		int movementZ = 0 - maxDistanceAway;

		while (true)
		{
			final int pointX = startX + movementX;
			final int pointY = startY + movementY;
			final int pointZ = startZ + movementZ;
			final int blockId = worldObj.getBlockId(pointX, pointY, pointZ);

			for (final int searchId : searchIDs)
			{
				if (blockId == searchId)
				{
					returnList.add(new Point3D(pointX, pointY, pointZ));
				}
			}

			if (movementX == maxDistanceAway && movementZ == maxDistanceAway && movementY == -1)
			{
				break;
			}

			if (movementX == maxDistanceAway && movementZ == maxDistanceAway)
			{
				//Reset for next level
				movementX = 0 - maxDistanceAway;
				movementY--;
				movementZ = 0 - maxDistanceAway;

				continue;
			}

			if (movementX == maxDistanceAway)
			{
				movementX = 0 - maxDistanceAway;
				movementZ++;
				continue;
			}

			movementX++;
		}

		return returnList;
	}
}
