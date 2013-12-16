package spellbound.spells;

import net.minecraft.block.Block;
import spellbound.enums.EnumItemInUseTime;

public class SpellWallOfStone extends AbstractSpellWall
{
	@Override
	public String getSpellDisplayName() 
	{
		return "Wall of Stone";
	}

	@Override
	public int getWallBlockId() 
	{
		return Block.stone.blockID;
	}
	
	@Override
	public EnumItemInUseTime getSpellDuration() 
	{
		return EnumItemInUseTime.INSTANT;
	}
}
