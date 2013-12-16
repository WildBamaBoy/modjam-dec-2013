package spellbound.spells;

import net.minecraft.block.Block;
import spellbound.enums.EnumItemInUseTime;

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
	public EnumItemInUseTime getSpellCastDuration() 
	{
		return EnumItemInUseTime.FOUR_SECONDS;
	}
}
