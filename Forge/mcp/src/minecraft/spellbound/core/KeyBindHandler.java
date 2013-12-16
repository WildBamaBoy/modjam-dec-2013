package spellbound.core;

import java.util.EnumSet;

import org.lwjgl.input.Keyboard;

import net.minecraft.client.settings.KeyBinding;
import cpw.mods.fml.client.registry.KeyBindingRegistry.KeyHandler;
import cpw.mods.fml.common.TickType;

public class KeyBindHandler extends KeyHandler
{
	public KeyBindHandler(KeyBinding[] keyBindings) 
	{
		super(keyBindings);
	}

	@Override
	public String getLabel() 
	{
		return "SpellboundKeys";
	}

	@Override
	public void keyDown(EnumSet<TickType> types, KeyBinding kb, boolean tickEnd, boolean isRepeat) 
	{
		if (tickEnd && !isRepeat)
		{
			switch (kb.keyCode)
			{
			case Keyboard.KEY_ADD: handleNextEye(); break;
			case Keyboard.KEY_SUBTRACT: handlePreviousEye(); break;
			case Keyboard.KEY_L: handleDismissEye(); break;
			}
		}
	}

	@Override
	public void keyUp(EnumSet<TickType> types, KeyBinding kb, boolean tickEnd) 
	{
		System.out.println("KEYUP");
	}

	@Override
	public EnumSet<TickType> ticks() 
	{
		return EnumSet.of(TickType.CLIENT);
	}

	private void handleNextEye()
	{
		System.out.println("Next eye");
	}

	private void handlePreviousEye()
	{
		System.out.println("Previous eye");
	}

	private void handleDismissEye()
	{
		System.out.println("Dismiss eye");
	}
}
