package spellbound.blocks;

import net.minecraft.block.BlockFlower;
import spellbound.spells.AbstractEffect;

public abstract class AbstractMushroom extends BlockFlower
{
	public AbstractMushroom(int itemId) 
	{
		super(itemId);
	}

	public abstract AbstractEffect getMushroomEffect();
}
