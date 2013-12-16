package spellbound.blocks;

import spellbound.core.SpellboundCore;
import spellbound.spells.AbstractSpell;

public class BlockMushroomBlueGrey extends AbstractMushroom
{
	public BlockMushroomBlueGrey(int itemId) 
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
				SpellboundCore.instance.blockHybridMushroomGrey.blockID, 
				SpellboundCore.instance.blockHybridMushroomOrangeGrey.blockID, 
				SpellboundCore.instance.blockHybridMushroomOrange.blockID
				};
	}

	@Override
	public int getOffspringId(int mateId) 
	{
		if (mateId == SpellboundCore.instance.blockHybridMushroomGrey.blockID)
		{
			return SpellboundCore.instance.blockHybridMushroomBlack.blockID;
		}
		
		else if (mateId == SpellboundCore.instance.blockHybridMushroomOrangeGrey.blockID)
		{
			return SpellboundCore.rand.nextBoolean() ? SpellboundCore.instance.blockHybridMushroomGrey.blockID : SpellboundCore.instance.blockHybridMushroomLightBlue.blockID;
		}
		
		else if (mateId == SpellboundCore.instance.blockHybridMushroomOrange.blockID)
		{
			return SpellboundCore.instance.blockHybridMushroomOrangeGrey.blockID;
		}
		
		else
		{
			return -1;
		}
	}
}
