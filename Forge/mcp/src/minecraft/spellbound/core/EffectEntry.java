package spellbound.core;

import spellbound.effects.AbstractEffect;

public class EffectEntry 
{
	public AbstractEffect effect;
	public int durationCounter;
	public int maxDuration;
	
	public EffectEntry(AbstractEffect effect, int maxDuration)
	{
		this.effect = effect;
		this.maxDuration = maxDuration;
	}
}
