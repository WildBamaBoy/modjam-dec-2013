package spellbound.item;

import spellbound.core.SB;
import net.minecraft.item.Item;

public class SBItem extends Item
{
	public SBItem(int itemId, String unlocalizedName)
	{
		super(itemId);
		this.setCreativeTab(SB.instance.spellboundTab);
		this.setUnlocalizedName(unlocalizedName);
		this.setTextureName("spellbound:" + unlocalizedName);
	}
}
