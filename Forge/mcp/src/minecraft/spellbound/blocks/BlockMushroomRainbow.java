package spellbound.blocks;

import spellbound.core.SpellboundCore;
import spellbound.spells.AbstractSpell;

public class BlockMushroomRainbow extends AbstractMushroom
{
	public BlockMushroomRainbow(int itemId) 
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
		this.setUnlocalizedName("RAINBOW HYBRID");
	}

	@Override
	public void setTexture() 
	{
		this.setTextureName("spellbound:mushroom_rainbow");
	}

	@Override
	public int[] getMateIds() 
	{
		return new int[]
			{
			SpellboundCore.instance.blockHybridMushroomYellow.blockID,
			SpellboundCore.instance.blockHybridMushroomGrey.blockID
			};
	}

	@Override
	public int getOffspringId(int mateId) 
	{
		if (mateId == SpellboundCore.instance.blockHybridMushroomYellow.blockID)
		{
			return SpellboundCore.instance.blockHybridMushroomGold.blockID;
		}
		
		else if (mateId == SpellboundCore.instance.blockHybridMushroomGrey.blockID)
		{
			return SpellboundCore.instance.blockHybridMushroomPurple.blockID;
		}
		
		else
		{
			return -1;
		}
	}
}
