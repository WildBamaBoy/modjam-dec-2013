package spellbound.gen;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.IChunkProvider;
import spellbound.core.SpellboundCore;
import cpw.mods.fml.common.IWorldGenerator;

public class WorldGenMushrooms implements IWorldGenerator
{
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) 
	{
		final BiomeGenBase biome = world.getBiomeGenForCoords(chunkX * 16, chunkZ * 16);
		
		//TODO: Set spawn locations
		for (int loop = 0; loop < 20; loop++)
		{
			int genX = chunkX * 16 + random.nextInt(16);
			int genY = random.nextInt(90); //TODO CHECK
			int genZ = chunkZ * 16 + random.nextInt(16);

			if (world.getBlockId(genX, genY, genZ) == Block.grass.blockID)
			{
				world.setBlock(genX, genY + 1, genZ, SpellboundCore.instance.blockPrimaryMushroomRedOrange.blockID);
			}
		}
	}
}
