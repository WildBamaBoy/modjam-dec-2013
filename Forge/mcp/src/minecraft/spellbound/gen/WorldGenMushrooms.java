package spellbound.gen;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.ChunkProviderFlat;
import spellbound.core.SpellboundCore;
import cpw.mods.fml.common.IWorldGenerator;

public class WorldGenMushrooms implements IWorldGenerator
{
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) 
	{
		final BiomeGenBase biome = world.getBiomeGenForCoords(chunkX * 16, chunkZ * 16);

		if (!(chunkGenerator instanceof ChunkProviderFlat))
		{
			for (int loop = 0; loop < 20; loop++)
			{
				int genX = chunkX * 16 + random.nextInt(16);
				int genY = random.nextInt(90);
				int genZ = chunkZ * 16 + random.nextInt(16);

				int spawnId = SpellboundCore.instance.blockPrimaryMushroomRedOrange.blockID;

				if (random.nextBoolean())
				{
					spawnId = SpellboundCore.instance.blockPrimaryMushroomPinkOrange.blockID;
				}

				else if (random.nextBoolean())
				{
					spawnId = SpellboundCore.instance.blockPrimaryMushroomBlueGrey.blockID;
				}

				if (world.getBlockId(genX, genY, genZ) == Block.grass.blockID)
				{
					world.setBlock(genX, genY + 1, genZ, spawnId);
				}
			}
		}
	}
}
