package spellbound.blocks;

import spellbound.effects.AbstractEffect;

public class BlockMushroomBlueGrey extends AbstractMushroom
{
	public BlockMushroomBlueGrey(int itemId) 
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
		this.setUnlocalizedName("BLUEGREYPRIMARY");
	}

	@Override
	public void setTexture() 
	{
		this.setTextureName("spellbound:mushroom_bluegrey");
	}
}
