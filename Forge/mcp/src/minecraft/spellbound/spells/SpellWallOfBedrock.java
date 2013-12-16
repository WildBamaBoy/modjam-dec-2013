package spellbound.spells;

import spellbound.enums.EnumItemInUseTime;
import net.minecraft.block.Block;

public class SpellWallOfBedrock extends AbstractSpellWall
{
	@Override
	public String getSpellDisplayName() 
	{
		return "Wall of Bedrock";
	}

	@Override
	public int getWallBlockId() 
	{
		return Block.bedrock.blockID;
	}
	
	@Override
	public EnumItemInUseTime getSpellDuration() 
	{
		return EnumItemInUseTime.FOUR_SECONDS;
	}
}
