package spellbound.item;

import cpw.mods.fml.common.registry.LanguageRegistry;
import spellbound.core.SB;
import net.minecraft.item.Item;

public class SBItem extends Item
{
	public SBItem(int itemId, String unlocalizedName, String displayName)
	{
		super(itemId);
		this.setCreativeTab(SB.instance.spellboundTab);
		this.setUnlocalizedName(unlocalizedName);
		this.setTextureName("spellbound:" + unlocalizedName);
		LanguageRegistry.addName(this, displayName);
	}
}
