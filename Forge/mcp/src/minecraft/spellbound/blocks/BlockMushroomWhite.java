package spellbound.blocks;

import spellbound.effects.AbstractEffect;

public class BlockMushroomWhite extends AbstractMushroom
{
	public BlockMushroomWhite(int itemId) 
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
		this.setUnlocalizedName("WHITE HYBRID");
	}

	@Override
	public void setTexture() 
	{
		this.setTextureName("spellbound:mushroom_white");
	}
}
