package spellbound.core;

import net.minecraftforge.client.event.sound.SoundLoadEvent;
import net.minecraftforge.event.ForgeSubscribe;

public class SBEventHandler 
{
	@ForgeSubscribe
	public void onSound(SoundLoadEvent event)
	{
		event.manager.soundPoolSounds.addSound("spellbound:banshee.ogg");
	}
}
