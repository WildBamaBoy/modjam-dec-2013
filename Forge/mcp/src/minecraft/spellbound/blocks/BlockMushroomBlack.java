package spellbound.blocks;

import spellbound.effects.AbstractEffect;

public class BlockMushroomBlack extends AbstractMushroom
{
	public BlockMushroomBlack(int itemId) 
	{
		super(itemId);
	}

	@Override
	public AbstractEffect getMushroomEffect() 
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
}
