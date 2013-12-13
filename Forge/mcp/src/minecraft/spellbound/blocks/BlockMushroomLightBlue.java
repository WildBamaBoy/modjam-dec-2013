package spellbound.blocks;

import spellbound.effects.AbstractEffect;

public class BlockMushroomLightBlue extends AbstractMushroom
{
	public BlockMushroomLightBlue(int itemId) 
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
		this.setUnlocalizedName("LIGHT BLUE HYBRID");
	}

	@Override
	public void setTexture() 
	{
		this.setTextureName("spellbound:mushroom_lightblue");
	}
}
