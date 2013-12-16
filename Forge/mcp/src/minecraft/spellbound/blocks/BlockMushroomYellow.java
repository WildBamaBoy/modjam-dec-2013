package spellbound.blocks;

import spellbound.core.SpellboundCore;
import spellbound.spells.AbstractSpell;

public class BlockMushroomYellow extends AbstractMushroom
{
	public BlockMushroomYellow(int itemId) 
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
				SpellboundCore.instance.blockHybridMushroomRainbow.blockID,
				SpellboundCore.instance.blockPrimaryMushroomRedOrange.blockID
				};
	}

	@Override
	public int getOffspringId(int mateId) 
	{
		if (mateId == SpellboundCore.instance.blockPrimaryMushroomRedOrange.blockID)
		{
			return SpellboundCore.instance.blockHybridMushroomRainbow.blockID;
		}
		
		else if (mateId == SpellboundCore.instance.blockHybridMushroomRainbow.blockID)
		{
			return SpellboundCore.instance.blockHybridMushroomGold.blockID;
		}
		
		else
		{
			return -1;
		}
	}
}
