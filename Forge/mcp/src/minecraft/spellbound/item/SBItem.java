package spellbound.item;

import net.minecraft.item.Item;
import spellbound.core.SB;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class SBItem extends Item
{
	public SBItem(int itemId, String unlocalizedName, String displayName)
	{
		super(itemId);
		this.setUnlocalizedName(unlocalizedName);
		this.setTextureName("spellbound:" + unlocalizedName);
		LanguageRegistry.addName(this, displayName);
		
		//For easy init.
		if (SB.instance.spellboundTab != null)
		{
			this.setCreativeTab(SB.instance.spellboundTab);
		}
	}
}
