package spellbound.blocks;

import spellbound.core.SB;
import spellbound.effects.AbstractEffect;

public class BlockMushroomRainbow extends AbstractMushroom
{
	public BlockMushroomRainbow(int itemId) 
	{
		super(itemId);
	}

	@Override
	public AbstractEffect getMushroomEffect() 
	{
		return null;
	}

	@Override
	public void setName() 
	{
		this.setUnlocalizedName("RAINBOW HYBRID");
	}

	@Override
	public void setTexture() 
	{
		this.setTextureName("spellbound:mushroom_rainbow");
	}

	@Override
	public int[] getMateIds() 
	{
		return new int[]
			{
			SB.instance.blockHybridMushroomYellow.blockID	
			};
	}

	@Override
	public int getOffspringId(int mateId) 
	{
		if (mateId == SB.instance.blockHybridMushroomYellow.blockID)
		{
			return SB.instance.blockHybridMushroomGold.blockID;
		}
		
		else
		{
			return -1;
		}
	}
}
