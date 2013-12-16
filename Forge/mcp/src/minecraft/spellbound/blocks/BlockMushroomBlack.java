package spellbound.blocks;

import spellbound.spells.AbstractSpell;

public class BlockMushroomBlack extends AbstractMushroom
{
	public BlockMushroomBlack(int itemId) 
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
		this.setUnlocalizedName("BLACK HYBRID");
	}

	@Override
	public void setTexture() 
	{
		this.setTextureName("spellbound:mushroom_black");
	}

	@Override
	public int[] getMateIds() 
	{
		return null;
	}

	@Override
	public int getOffspringId(int mateId) 
	{
		return -1;
	}
}
