package spellbound.blocks;

import spellbound.core.SpellboundCore;
import spellbound.spells.AbstractSpell;

public class BlockMushroomWhite extends AbstractMushroom
{
	public BlockMushroomWhite(int itemId) 
	{
		super(itemId);
	}

	@Override
	public AbstractSpell getMushroomSpell() 
	{
		return null;
	}

	@Override
	public void setName() 
	{
		this.setUnlocalizedName("WHITE HYBRID");
	}

	@Override
	public void setTexture() 
	{
		this.setTextureName("spellbound:mushroom_white");
	}

	@Override
	public int[] getMateIds() 
	{
		return new int[]
				{
				SpellboundCore.instance.blockHybridMushroomBlack.blockID,
				SpellboundCore.instance.blockHybridMushroomOrange.blockID,
				SpellboundCore.instance.blockHybridMushroomWhite.blockID,
				SpellboundCore.instance.blockHybridMushroomOrangeGrey.blockID, //Orange + BlueGrey
				SpellboundCore.instance.blockHybridMushroomLightBlue.blockID, //GreyOrange + BlueGrey //COLD!
				SpellboundCore.instance.blockHybridMushroomGrey.blockID, //GreyOrange + BlueGrey >>>Also
				SpellboundCore.instance.blockHybridMushroomYellow.blockID, //OrangeGrey + Grey //LIGHTNING!
				SpellboundCore.instance.blockHybridMushroomRainbow.blockID, //Red Orange + Yellow //RANDOM! //2nd LEVEL
				SpellboundCore.instance.blockHybridMushroomGold.blockID, //Rainbow + Yellow //2nd level
				SpellboundCore.instance.blockHybridMushroomBlack.blockID //Blue Grey + Grey //2nd level
				};
	}

	@Override
	public int getOffspringId(int mateId) 
	{
		return mateId;
	}
}
