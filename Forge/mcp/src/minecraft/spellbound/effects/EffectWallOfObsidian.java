package spellbound.effects;

import net.minecraft.block.Block;
import spellbound.enums.EnumSpellType;

public class EffectWallOfObsidian extends AbstractEffectWall
{
	@Override
	public String getSpellDisplayName() 
	{
		return "Wall of Obsidian";
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
		return Block.obsidian.blockID;
	}
}
