package spellbound.effects;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import spellbound.enums.EnumSpellType;

public class EffectWallOfObsidian extends AbstractEffectWall
{
	@Override
	public String getSpellDisplayName() 
	{
		return "Wall of Obsidian";
	}

	@Override
	public void doSpellEffect(EntityPlayer caster) 
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

	@Override
	public void doSpellTargetEffect(World worldObj, int posX, int posY, int posZ) {
		// TODO Auto-generated method stub
		
	}
}
