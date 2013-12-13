package spellbound.blocks;

import spellbound.effects.AbstractEffect;

public class BlockMushroomGold extends AbstractMushroom
{
	public BlockMushroomGold(int itemId) 
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
		this.setUnlocalizedName("GREY ORANGE HYBRID");
	}

	@Override
	public void setTexture() 
	{
		this.setTextureName("spellbound:mushroom_greyorange");
	}
}
