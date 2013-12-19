package spellbound.item;

import net.minecraft.item.Item;
import spellbound.core.SpellboundCore;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class SpellboundItem extends Item
{
	public SpellboundItem(int itemId, String unlocalizedName, String displayName)
	{
		super(itemId);
		this.setUnlocalizedName(unlocalizedName);
		this.setTextureName("spellbound:" + unlocalizedName);
		LanguageRegistry.addName(this, displayName);
		
		//For easy init.
		if (SpellboundCore.getInstance().spellboundTab != null)
		{
			this.setCreativeTab(SpellboundCore.getInstance().spellboundTab);
		}
	}
}
