/**********************************************
 * WorldGenMushrooms.java
 * Copyright (c) 2013 Wild Bama Boy.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl.html
 **********************************************/

package spellbound.gen;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.ChunkProviderFlat;
import spellbound.core.SpellboundCore;
import cpw.mods.fml.common.IWorldGenerator;

public class WorldGenMushrooms implements IWorldGenerator
{
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) 
	{
		if (!(chunkGenerator instanceof ChunkProviderFlat))
		{
			for (int loop = 0; loop < 20; loop++)
			{
				final int genX = chunkX * 16 + random.nextInt(16);
				final int genY = random.nextInt(90);
				final int genZ = chunkZ * 16 + random.nextInt(16);

				int spawnId = SpellboundCore.getInstance().blockPrimaryMushroomRedOrange.blockID;

				if (random.nextBoolean())
				{
					spawnId = SpellboundCore.getInstance().blockPrimaryMushroomPinkOrange.blockID;
				}

				else if (random.nextBoolean())
				{
					spawnId = SpellboundCore.getInstance().blockPrimaryMushroomBlueGrey.blockID;
				}

				if (world.getBlockId(genX, genY, genZ) == Block.grass.blockID)
				{
					world.setBlock(genX, genY + 1, genZ, spawnId);
				}
			}
		}
	}
}
