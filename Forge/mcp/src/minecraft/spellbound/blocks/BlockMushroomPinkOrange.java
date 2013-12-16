package spellbound.blocks;

import spellbound.core.SpellboundCore;
import spellbound.spells.AbstractSpell;

public class BlockMushroomPinkOrange extends AbstractMushroom
{
	public BlockMushroomPinkOrange(int itemId) 
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
				SpellboundCore.instance.blockPrimaryMushroomRedOrange.blockID
				};
	}

	@Override
	public int getOffspringId(int mateId) 
	{
		if (mateId == SpellboundCore.instance.blockPrimaryMushroomRedOrange.blockID)
		{
			return SpellboundCore.rand.nextBoolean() ? SpellboundCore.instance.blockHybridMushroomWhite.blockID : SpellboundCore.instance.blockHybridMushroomOrange.blockID;
		}
		
		else
		{
			return -1;
		}
	}	
}
