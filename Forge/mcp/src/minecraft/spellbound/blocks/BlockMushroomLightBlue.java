package spellbound.blocks;

import spellbound.spells.AbstractSpell;

public class BlockMushroomLightBlue extends AbstractMushroom
{
	public BlockMushroomLightBlue(int itemId) 
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
		this.setUnlocalizedName("LIGHT BLUE HYBRID");
	}

	@Override
	public void setTexture() 
	{
		this.setTextureName("spellbound:mushroom_lightblue");
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
