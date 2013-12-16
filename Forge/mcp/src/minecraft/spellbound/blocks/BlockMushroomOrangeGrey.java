package spellbound.blocks;

import spellbound.core.SpellboundCore;
import spellbound.spells.AbstractSpell;

public class BlockMushroomOrangeGrey extends AbstractMushroom
{
	public BlockMushroomOrangeGrey(int itemId) 
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
				SpellboundCore.instance.blockPrimaryMushroomBlueGrey.blockID
				};
	}

	@Override
	public int getOffspringId(int mateId)
	{
		if (mateId == SpellboundCore.instance.blockPrimaryMushroomBlueGrey.blockID)
		{
			return SpellboundCore.rand.nextBoolean() ? SpellboundCore.instance.blockHybridMushroomLightBlue.blockID : SpellboundCore.instance.blockHybridMushroomGrey.blockID;
		}
		
		else
		{
			return -1;
		}
	}
}
