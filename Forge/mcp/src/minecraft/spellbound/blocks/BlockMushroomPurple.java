package spellbound.blocks;

import spellbound.core.SpellboundCore;
import spellbound.spells.AbstractSpell;

public class BlockMushroomPurple extends AbstractMushroom
{
	public BlockMushroomPurple(int itemId) 
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
		this.setUnlocalizedName("PURPLE HYBRID");
	}

	@Override
	public void setTexture() 
	{
		this.setTextureName("spellbound:mushroom_purple");
	}

	@Override
	public int[] getMateIds() 
	{
		return new int[0];
	}

	@Override
	public int getOffspringId(int mateId) 
	{
		return -1;
	}
}
