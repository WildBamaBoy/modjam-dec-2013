package spellbound.core;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet250CustomPayload;
import spellbound.spells.AbstractSpellScrying;
import cpw.mods.fml.common.network.IPacketHandler;
import cpw.mods.fml.common.network.PacketDispatcher;
import cpw.mods.fml.common.network.Player;

public class PacketHandler implements IPacketHandler
{
	@Override
	public void onPacketData(INetworkManager manager, Packet250CustomPayload packet, Player player) 
	{
		try
		{
			if (packet.channel.equals("SB_LIGHTNING"))
			{
				handleLightningPacket(packet, player);
			}

			else if (packet.channel.equals("SB_GETNEXTEYE"))
			{
				handleGetNextEyePacket(packet, player);
			}

			else if (packet.channel.equals("SB_NEXTEYE"))
			{
				handleNextEyePacket(packet, player);
			}
			
			else if (packet.channel.equals("SB_CHATMESSAGE"))
			{
				handleChatMessagePacket(packet, player);
			}
			
			else if (packet.channel.equals("SB_FLIGHT"))
			{
				handleFlightPacket(packet, player);
			}
		}

		catch (Throwable e)
		{
			e.printStackTrace();
		}
	}

	public static Packet250CustomPayload createLightningPacket(double x, double y, double z)
	{
		try
		{
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			ObjectOutputStream objOut = new ObjectOutputStream(out);

			Packet250CustomPayload packet = new Packet250CustomPayload();
			packet.channel = "SB_LIGHTNING";

			objOut.writeObject(x);
			objOut.writeObject(y);
			objOut.writeObject(z);

			packet.data = out.toByteArray();
			packet.length = packet.data.length;

			return packet;
		}

		catch (IOException e)
		{
			e.printStackTrace();
			return null;
		}
	}

	private void handleLightningPacket(Packet250CustomPayload packet, Player player) throws IOException, ClassNotFoundException
	{
		EntityPlayer entityPlayer = (EntityPlayer)player;

		byte[] data = packet.data;

		ByteArrayInputStream input = new ByteArrayInputStream(data);
		ObjectInputStream objectInput = new ObjectInputStream(input);

		double x = (Double) objectInput.readObject();
		double y = (Double) objectInput.readObject();
		double z = (Double) objectInput.readObject();

		EntityLightningBolt lightning = new EntityLightningBolt(entityPlayer.worldObj, x, y, z);
		entityPlayer.worldObj.spawnEntityInWorld(lightning);
	}

	public static Packet250CustomPayload createGetNextEyePacket(int playerId, int currentEyeIndex)
	{
		try
		{
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			ObjectOutputStream objOut = new ObjectOutputStream(out);

			Packet250CustomPayload packet = new Packet250CustomPayload();
			packet.channel = "SB_GETNEXTEYE";

			objOut.writeObject(playerId);
			objOut.writeObject(SpellboundCore.instance.currentEyeIndex);

			packet.data = out.toByteArray();
			packet.length = packet.data.length;

			return packet;
		}

		catch (IOException e)
		{
			e.printStackTrace();
			return null;
		}
	}

	private void handleGetNextEyePacket(Packet250CustomPayload packet, Player player) throws IOException, ClassNotFoundException
	{
		EntityPlayer entityPlayer = (EntityPlayer)player;

		byte[] data = packet.data;

		ByteArrayInputStream input = new ByteArrayInputStream(data);
		ObjectInputStream objectInput = new ObjectInputStream(input);

		int playerId = (Integer)objectInput.readObject();
		int currentEyeIndex = (Integer)objectInput.readObject();

		List<SpellEntry> spellEntries = SpellboundCore.activeSpells.get(entityPlayer);
		AbstractSpellScrying nextSpell = null;

		for (int index = currentEyeIndex == -1 ? 0 : currentEyeIndex ; index < spellEntries.size(); index++)
		{
			System.out.println("AAA");
			SpellEntry entry = spellEntries.get(index);

			if (entry.spell instanceof AbstractSpellScrying)
			{
				nextSpell = (AbstractSpellScrying)entry.spell;
			}
		}

		if (nextSpell == null)
		{
			PacketDispatcher.sendPacketToPlayer(createNextEyePacket(-1), player);
		}

		else
		{
			PacketDispatcher.sendPacketToPlayer(createNextEyePacket(nextSpell.eye.entityId), player);
		}
	}

	public static Packet250CustomPayload createNextEyePacket(int eyeEntityId)
	{
		try
		{
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			ObjectOutputStream objOut = new ObjectOutputStream(out);

			Packet250CustomPayload packet = new Packet250CustomPayload();
			packet.channel = "SB_NEXTEYE";

			objOut.writeObject(eyeEntityId);

			packet.data = out.toByteArray();
			packet.length = packet.data.length;

			return packet;
		}

		catch (IOException e)
		{
			e.printStackTrace();
			return null;
		}
	}

	private void handleNextEyePacket(Packet250CustomPayload packet, Player player) throws IOException, ClassNotFoundException
	{
		EntityPlayer entityPlayer = (EntityPlayer)player;

		byte[] data = packet.data;

		ByteArrayInputStream input = new ByteArrayInputStream(data);
		ObjectInputStream objectInput = new ObjectInputStream(input);

		int nextEyeId = (Integer)objectInput.readObject();

		if (nextEyeId == -1)
		{
			System.out.println("PLAYER!");
			Minecraft.getMinecraft().renderViewEntity = Minecraft.getMinecraft().thePlayer;
		}

		else
		{
			Entity entity = entityPlayer.worldObj.getEntityByID(nextEyeId);

			if (entity != null)
			{
				Minecraft.getMinecraft().renderViewEntity = (EntityLivingBase) (entity);
			}

			else
			{
				System.out.println("Next eye could not be found.");
			}
		}
	}
	
	public static Packet250CustomPayload createChatMessagePacket(String message)
	{
		try
		{
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			ObjectOutputStream objOut = new ObjectOutputStream(out);

			Packet250CustomPayload packet = new Packet250CustomPayload();
			packet.channel = "SB_CHATMESSAGE";

			objOut.writeObject(message);

			packet.data = out.toByteArray();
			packet.length = packet.data.length;

			return packet;
		}

		catch (IOException e)
		{
			e.printStackTrace();
			return null;
		}
	}

	private void handleChatMessagePacket(Packet250CustomPayload packet, Player player) throws IOException, ClassNotFoundException
	{
		EntityPlayer entityPlayer = (EntityPlayer)player;

		byte[] data = packet.data;

		ByteArrayInputStream input = new ByteArrayInputStream(data);
		ObjectInputStream objectInput = new ObjectInputStream(input);

		String message = (String) objectInput.readObject();

		entityPlayer.addChatMessage(message);
	}
	
	public static Packet250CustomPayload createFlightPacket(Boolean enable)
	{
		try
		{
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			ObjectOutputStream objOut = new ObjectOutputStream(out);

			Packet250CustomPayload packet = new Packet250CustomPayload();
			packet.channel = "SB_FLIGHT";

			objOut.writeObject(enable);

			packet.data = out.toByteArray();
			packet.length = packet.data.length;

			return packet;
		}

		catch (IOException e)
		{
			e.printStackTrace();
			return null;
		}
	}

	private void handleFlightPacket(Packet250CustomPayload packet, Player player) throws IOException, ClassNotFoundException
	{
		EntityPlayer entityPlayer = (EntityPlayer)player;

		byte[] data = packet.data;

		ByteArrayInputStream input = new ByteArrayInputStream(data);
		ObjectInputStream objectInput = new ObjectInputStream(input);

		boolean enable = (Boolean) objectInput.readObject();

		if (enable)
		{
			entityPlayer.capabilities.allowFlying = true;
			entityPlayer.fallDistance = 0;
			entityPlayer.motionY += 1.0D;
			entityPlayer.capabilities.isFlying = true;
		}
		
		else
		{
			entityPlayer.capabilities.allowFlying = false;
			entityPlayer.capabilities.isFlying = false;
		}
	}
}
