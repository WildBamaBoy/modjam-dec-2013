package spellbound.blocks;

import spellbound.core.SB;
import spellbound.effects.AbstractEffect;

public class BlockMushroomRedOrange extends AbstractMushroom
{
	public BlockMushroomRedOrange(int itemId) 
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
		this.setUnlocalizedName("RED ORANGE PRIMARY");
	}

	@Override
	public void setTexture() 
	{
		this.setTextureName("spellbound:mushroom_redorange");
	}

	@Override
	public int[] getMateIds() 
	{
		return new int[]
				{
				SB.instance.blockHybridMushroomYellow.blockID,
				SB.instance.blockPrimaryMushroomPinkOrange.blockID
				};
	}

	@Override
	public int getOffspringId(int mateId) 
	{
		if (mateId == SB.instance.blockHybridMushroomYellow.blockID)
		{
			return SB.instance.blockHybridMushroomRainbow.blockID;
		}
		
		else if (mateId == SB.instance.blockPrimaryMushroomPinkOrange.blockID)
		{
			return SB.rand.nextBoolean() ? SB.instance.blockHybridMushroomOrange.blockID : SB.instance.blockHybridMushroomWhite.blockID;
		}
		
		else
		{
			return -1;
		}
	}
}
