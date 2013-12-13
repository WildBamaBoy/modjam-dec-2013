package spellbound.core;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import spellbound.util.Coordinates;

public final class Logic 
{
	public static Coordinates getNearbyBlockTopBottom(World worldObj, int startX, int startY, int startZ, int maxDistanceAway, int searchId)
	{
		int movementX = 0 - maxDistanceAway;
		int movementY = 1;
		int movementZ = 0 - maxDistanceAway;

		while (true)
		{
			final int blockId = worldObj.getBlockId(startX + movementX, startY + movementY, startZ + movementZ);
			int coordsX = startX + movementX;
			int coordsY = startY + movementY;
			int coordsZ = startZ + movementZ;
			
			if (blockId == searchId)
			{
				//Only for mushrooms. Check if block above is clear of obstruction.
				if (worldObj.getBlockId(coordsX, coordsY + 1, coordsZ) == 0 &&
					coordsX != startX && coordsY != startY && coordsZ != startZ)
				{
					return new Coordinates(coordsX, coordsY + 1, coordsZ);
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
