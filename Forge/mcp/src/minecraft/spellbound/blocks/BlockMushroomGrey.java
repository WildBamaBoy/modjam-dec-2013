package spellbound.blocks;

import spellbound.effects.AbstractEffect;

public class BlockMushroomGrey extends AbstractMushroom
{
	public BlockMushroomGrey(int itemId) 
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
		this.setUnlocalizedName("GREY HYBRID");
	}

	@Override
	public void setTexture() 
	{
		this.setTextureName("spellbound:mushroom_grey");
	}
}
