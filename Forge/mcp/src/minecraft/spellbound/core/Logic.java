package spellbound.core;

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
			final int blockId = worldObj.getBlockId(movementX, movementY, movementZ);

			if (blockId == searchId)
			{
				//Return coordinates
				return new Coordinates(startX + movementX, startY + movementY, startZ + movementZ);
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
				movementX = 0;
				movementZ++;
			}
			
			movementX++;
		}
	}
}
