package spellbound.blocks;

import spellbound.effects.AbstractEffect;

public class BlockMushroomPinkOrange extends AbstractMushroom
{
	public BlockMushroomPinkOrange(int itemId) 
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
		this.setUnlocalizedName("Pink ORANGE PRIMARY");
	}

	@Override
	public void setTexture() 
	{
		this.setTextureName("spellbound:mushroom_pinkorange");
	}	
}
