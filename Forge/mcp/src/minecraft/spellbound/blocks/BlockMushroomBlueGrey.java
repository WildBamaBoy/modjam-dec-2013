package spellbound.blocks;

import spellbound.core.SB;
import spellbound.effects.AbstractEffect;

public class BlockMushroomBlueGrey extends AbstractMushroom
{
	public BlockMushroomBlueGrey(int itemId) 
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
		this.setUnlocalizedName("BLUEGREYPRIMARY");
	}

	@Override
	public void setTexture() 
	{
		this.setTextureName("spellbound:mushroom_bluegrey");
	}

	@Override
	public int[] getMateIds() 
	{
		//Grey, GreyOrange, Orange
		return new int[]
				{
				SB.instance.blockHybridMushroomGrey.blockID, 
				SB.instance.blockHybridMushroomGreyOrange.blockID, 
				SB.instance.blockHybridMushroomOrange.blockID
				};
	}

	@Override
	public int getOffspringId(int mateId) 
	{
		if (mateId == SB.instance.blockHybridMushroomGrey.blockID)
		{
			return SB.instance.blockHybridMushroomBlack.blockID;
		}
		
		else if (mateId == SB.instance.blockHybridMushroomGreyOrange.blockID)
		{
			return SB.rand.nextBoolean() ? SB.instance.blockHybridMushroomGrey.blockID : SB.instance.blockHybridMushroomLightBlue.blockID;
		}
		
		else if (mateId == SB.instance.blockHybridMushroomOrange.blockID)
		{
			return SB.instance.blockHybridMushroomGreyOrange.blockID;
		}
		
		else
		{
			return -1;
		}
	}
}
