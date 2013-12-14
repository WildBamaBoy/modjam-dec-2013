package spellbound.blocks;

import spellbound.core.SB;
import spellbound.effects.AbstractEffect;

public class BlockMushroomYellow extends AbstractMushroom
{
	public BlockMushroomYellow(int itemId) 
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
		this.setUnlocalizedName("YellowHybrid");
	}

	@Override
	public void setTexture() 
	{
		this.setTextureName("spellbound:mushroom_yellow");
	}

	@Override
	public int[] getMateIds() 
	{
		return new int[]
				{
				SB.instance.blockHybridMushroomRainbow.blockID,
				SB.instance.blockPrimaryMushroomRedOrange.blockID
				};
	}

	@Override
	public int getOffspringId(int mateId) 
	{
		if (mateId == SB.instance.blockPrimaryMushroomRedOrange.blockID)
		{
			return SB.instance.blockHybridMushroomRainbow.blockID;
		}
		
		else if (mateId == SB.instance.blockHybridMushroomRainbow.blockID)
		{
			return SB.instance.blockHybridMushroomGold.blockID;
		}
		
		else
		{
			return -1;
		}
	}
}
