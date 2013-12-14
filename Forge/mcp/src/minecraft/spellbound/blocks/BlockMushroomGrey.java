package spellbound.blocks;

import spellbound.core.SB;
import spellbound.effects.AbstractEffect;

public class BlockMushroomGrey extends AbstractMushroom
{
	public BlockMushroomGrey(int itemId) 
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
		this.setUnlocalizedName("GREY HYBRID");
	}

	@Override
	public void setTexture() 
	{
		this.setTextureName("spellbound:mushroom_grey");
	}

	@Override
	public int[] getMateIds() 
	{
		return new int[]
				{
			SB.instance.blockHybridMushroomOrangeGrey.blockID,
			SB.instance.blockPrimaryMushroomBlueGrey.blockID
				};
	}

	@Override
	public int getOffspringId(int mateId) 
	{
		if (mateId == SB.instance.blockHybridMushroomOrangeGrey.blockID)
		{
			return SB.instance.blockHybridMushroomYellow.blockID;
		}
		
		else if (mateId == SB.instance.blockPrimaryMushroomBlueGrey.blockID)
		{
			return SB.instance.blockHybridMushroomBlack.blockID;
		}
		
		else
		{
			return -1;
		}
	}
}
