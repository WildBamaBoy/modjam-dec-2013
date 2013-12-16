package spellbound.core;

import net.minecraftforge.client.event.sound.SoundLoadEvent;
import net.minecraftforge.event.ForgeSubscribe;

public class EventHandler 
{
	@ForgeSubscribe
	public void onSound(SoundLoadEvent event)
	{
		event.manager.soundPoolSounds.addSound("spellbound:banshee.ogg");
		event.manager.soundPoolSounds.addSound("spellbound:spellcharge1second.ogg");
		event.manager.soundPoolSounds.addSound("spellbound:spellcharge2seconds.ogg");
		event.manager.soundPoolSounds.addSound("spellbound:spellcharge3seconds.ogg");
		event.manager.soundPoolSounds.addSound("spellbound:spellcharge4seconds.ogg");
		event.manager.soundPoolSounds.addSound("spellbound:spellcharge5seconds.ogg");
	}
}
