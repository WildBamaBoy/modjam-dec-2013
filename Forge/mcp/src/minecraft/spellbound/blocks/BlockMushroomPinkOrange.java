package spellbound.blocks;

import spellbound.core.SB;
import spellbound.effects.AbstractEffect;

public class BlockMushroomPinkOrange extends AbstractMushroom
{
	public BlockMushroomPinkOrange(int itemId) 
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
		this.setUnlocalizedName("Pink ORANGE PRIMARY");
	}

	@Override
	public void setTexture() 
	{
		this.setTextureName("spellbound:mushroom_pinkorange");
	}

	@Override
	public int[] getMateIds() 
	{
		return new int[]
				{
				SB.instance.blockPrimaryMushroomRedOrange.blockID
				};
	}

	@Override
	public int getOffspringId(int mateId) 
	{
		if (mateId == SB.instance.blockPrimaryMushroomRedOrange.blockID)
		{
			return SB.rand.nextBoolean() ? SB.instance.blockHybridMushroomWhite.blockID : SB.instance.blockHybridMushroomOrange.blockID;
		}
		
		else
		{
			return -1;
		}
	}	
}
