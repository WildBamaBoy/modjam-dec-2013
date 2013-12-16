package spellbound.core;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet250CustomPayload;
import cpw.mods.fml.common.network.IPacketHandler;
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

			else if (packet.channel.equals(""))
			{

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
}
