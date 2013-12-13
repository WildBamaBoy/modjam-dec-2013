package spellbound.blocks;

import spellbound.spells.AbstractEffect;

public class BlockMushroomRed extends AbstractMushroom
{
	public BlockMushroomRed(int itemId) 
	{
		super(itemId);
	}

	@Override
	public AbstractEffect getMushroomEffect() 
	{
		return null;
	}
}
