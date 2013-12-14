package spellbound.blocks;

import spellbound.core.SB;
import spellbound.effects.AbstractEffect;

public class BlockMushroomOrange extends AbstractMushroom
{
	public BlockMushroomOrange(int itemId) 
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
		this.setUnlocalizedName("ORANGE HYBRID");
	}

	@Override
	public void setTexture() 
	{
		this.setTextureName("spellbound:mushroom_orange");
	}

	@Override
	public int[] getMateIds() 
	{
		return new int[]
				{
				SB.instance.blockPrimaryMushroomBlueGrey.blockID
				};
	}

	@Override
	public int getOffspringId(int mateId) 
	{
		if (mateId == SB.instance.blockPrimaryMushroomBlueGrey.blockID)
		{
			return SB.instance.blockHybridMushroomGreyOrange.blockID;
		}
		
		else
		{
			return -1;
		}
	}
}
