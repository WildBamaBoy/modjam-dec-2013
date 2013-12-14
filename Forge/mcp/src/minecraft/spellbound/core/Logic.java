package spellbound.core;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import spellbound.blocks.AbstractMushroom;
import spellbound.util.MushroomCoordinates;

public final class Logic 
{
	public static MushroomCoordinates getNearbyBlockTopBottom(AbstractMushroom mushroom, World worldObj, int startX, int startY, int startZ, int maxDistanceAway, int[] searchIds)
	{
		int movementX = 0 - maxDistanceAway;
		int movementY = 1;
		int movementZ = 0 - maxDistanceAway;

		while (true)
		{
			final int coordsX = startX + movementX;
			final int coordsY = startY + movementY;
			final int coordsZ = startZ + movementZ;
			final int blockId = worldObj.getBlockId(coordsX, coordsY, coordsZ);

			for (int id : searchIds)
			{
				if (blockId == id)
				{
					//Only for mushrooms. Check if block above is clear of obstruction.
					if (worldObj.getBlockId(coordsX, coordsY + 1, coordsZ) == 0)
					{
						return new MushroomCoordinates(coordsX, coordsY + 1, coordsZ, mushroom.getOffspringId(id));
					}
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

	public static MushroomCoordinates getNearbyBlockTopBottom(World worldObj, int startX, int startY, int startZ, int maxDistanceAway, int searchId)
	{
		int movementX = 0 - maxDistanceAway;
		int movementY = 1;
		int movementZ = 0 - maxDistanceAway;

		while (true)
		{
			final int coordsX = startX + movementX;
			final int coordsY = startY + movementY;
			final int coordsZ = startZ + movementZ;
			final int blockId = worldObj.getBlockId(coordsX, coordsY, coordsZ);

			if (blockId == searchId)
			{
				//Only for mushrooms. Check if block above is clear of obstruction.
				if (worldObj.getBlockId(coordsX, coordsY + 1, coordsZ) == 0)
				{
					return new MushroomCoordinates(coordsX, coordsY + 1, coordsZ, blockId);
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
}
