package spellbound.effects;

import net.minecraft.block.Block;
import spellbound.enums.EnumSpellType;

public class EffectWallOfStone extends AbstractEffectWall
{
	@Override
	public String getSpellDisplayName() 
	{
		return "Wall of Stone";
	}

	@Override
	public void doSpellEffect() 
	{
		
	}

	@Override
	public void updateSpellEffect() 
	{
		
	}
	
	@Override
	public EnumSpellType getSpellType() 
	{
		return EnumSpellType.FRONT;
	}
	
	@Override
	public int getWallBlockId() 
	{
		return Block.stone.blockID;
	}
}
