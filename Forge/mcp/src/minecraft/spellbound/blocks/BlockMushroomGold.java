package spellbound.blocks;

import spellbound.spells.AbstractSpell;

public class BlockMushroomGold extends AbstractMushroom
{
	public BlockMushroomGold(int itemId) 
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
		this.setUnlocalizedName("GOLD HYBRID");
	}

	@Override
	public void setTexture() 
	{
		this.setTextureName("spellbound:mushroom_gold");
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
