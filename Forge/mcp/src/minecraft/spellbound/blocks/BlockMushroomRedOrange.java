package spellbound.blocks;

import spellbound.core.SpellboundCore;
import spellbound.spells.AbstractSpell;

public class BlockMushroomRedOrange extends AbstractMushroom
{
	public BlockMushroomRedOrange(int itemId) 
	{
		super(itemId);
	}

	@Override
	public AbstractSpell getMushroomSpell() 
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
				SpellboundCore.instance.blockHybridMushroomYellow.blockID,
				SpellboundCore.instance.blockPrimaryMushroomPinkOrange.blockID
				};
	}

	@Override
	public int getOffspringId(int mateId) 
	{
		if (mateId == SpellboundCore.instance.blockHybridMushroomYellow.blockID)
		{
			return SpellboundCore.instance.blockHybridMushroomRainbow.blockID;
		}
		
		else if (mateId == SpellboundCore.instance.blockPrimaryMushroomPinkOrange.blockID)
		{
			return SpellboundCore.rand.nextBoolean() ? SpellboundCore.instance.blockHybridMushroomOrange.blockID : SpellboundCore.instance.blockHybridMushroomWhite.blockID;
		}
		
		else
		{
			return -1;
		}
	}
}
