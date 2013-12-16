package spellbound.core;

import spellbound.spells.AbstractSpell;

public class SpellEntry 
{
	public AbstractSpell spell;
	public int durationCounter;
	public int maxDuration;
	
	public SpellEntry(AbstractSpell spell, int maxDuration)
	{
		this.spell = spell;
		this.maxDuration = maxDuration;
	}
}
