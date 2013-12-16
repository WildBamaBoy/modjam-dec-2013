package spellbound.blocks;

import spellbound.core.SpellboundCore;
import spellbound.spells.AbstractSpell;

public class BlockMushroomGrey extends AbstractMushroom
{
	public BlockMushroomGrey(int itemId) 
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
			SpellboundCore.instance.blockHybridMushroomOrangeGrey.blockID,
			SpellboundCore.instance.blockPrimaryMushroomBlueGrey.blockID
				};
	}

	@Override
	public int getOffspringId(int mateId) 
	{
		if (mateId == SpellboundCore.instance.blockHybridMushroomOrangeGrey.blockID)
		{
			return SpellboundCore.instance.blockHybridMushroomYellow.blockID;
		}
		
		else if (mateId == SpellboundCore.instance.blockPrimaryMushroomBlueGrey.blockID)
		{
			return SpellboundCore.instance.blockHybridMushroomBlack.blockID;
		}
		
		else
		{
			return -1;
		}
	}
}
