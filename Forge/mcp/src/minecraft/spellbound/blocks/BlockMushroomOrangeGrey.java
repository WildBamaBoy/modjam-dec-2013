package spellbound.blocks;

import spellbound.core.SB;
import spellbound.effects.AbstractEffect;

public class BlockMushroomOrangeGrey extends AbstractMushroom
{
	public BlockMushroomOrangeGrey(int itemId) 
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
		this.setUnlocalizedName("Orange Grey HYBRID");
	}

	@Override
	public void setTexture() 
	{
		this.setTextureName("spellbound:mushroom_orangegrey");
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
			return SB.rand.nextBoolean() ? SB.instance.blockHybridMushroomLightBlue.blockID : SB.instance.blockHybridMushroomGrey.blockID;
		}
		
		else
		{
			return -1;
		}
	}
}
