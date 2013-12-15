package spellbound.blocks;

import spellbound.core.SB;
import spellbound.effects.AbstractEffect;

public class BlockMushroomWhite extends AbstractMushroom
{
	public BlockMushroomWhite(int itemId) 
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
				SB.instance.blockHybridMushroomBlack.blockID,
				SB.instance.blockHybridMushroomOrange.blockID,
				SB.instance.blockHybridMushroomWhite.blockID,
				SB.instance.blockHybridMushroomOrangeGrey.blockID, //Orange + BlueGrey
				SB.instance.blockHybridMushroomLightBlue.blockID, //GreyOrange + BlueGrey //COLD!
				SB.instance.blockHybridMushroomGrey.blockID, //GreyOrange + BlueGrey >>>Also
				SB.instance.blockHybridMushroomYellow.blockID, //OrangeGrey + Grey //LIGHTNING!
				SB.instance.blockHybridMushroomRainbow.blockID, //Red Orange + Yellow //RANDOM! //2nd LEVEL
				SB.instance.blockHybridMushroomGold.blockID, //Rainbow + Yellow //2nd level
				SB.instance.blockHybridMushroomBlack.blockID //Blue Grey + Grey //2nd level
				};
	}

	@Override
	public int getOffspringId(int mateId) 
	{
		return mateId;
	}
}
