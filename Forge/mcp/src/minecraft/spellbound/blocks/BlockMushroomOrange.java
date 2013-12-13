package spellbound.blocks;

import spellbound.effects.AbstractEffect;

public class BlockMushroomOrange extends AbstractMushroom
{
	public BlockMushroomOrange(int itemId) 
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
		this.setUnlocalizedName("ORANGE HYBRID");
	}

	@Override
	public void setTexture() 
	{
		this.setTextureName("spellbound:mushroom_orange");
	}
}
