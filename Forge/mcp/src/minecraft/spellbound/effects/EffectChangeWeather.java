package spellbound.effects;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.World;
import spellbound.enums.EnumSpellType;

public class EffectChangeWeather extends AbstractEffect
{
	@Override
	public String getSpellDisplayName() 
	{
		return "Change Weather";
	}

	@Override
	public void doSpellEffect(EntityPlayer caster) 
	{
        MinecraftServer.getServer().worldServers[0].toggleRain();
        MinecraftServer.getServer().worldServers[0].getWorldInfo().setThundering(true);
	}

	@Override
	public void updateSpellEffect() 
	{
		
	}
	
	@Override
	public EnumSpellType getSpellType() 
	{
		return EnumSpellType.SELF;
	}

	@Override
	public void doSpellTargetEffect(World worldObj, int posX, int posY, int posZ, EntityLivingBase entityHit); {
		// TODO Auto-generated method stub
		
	}
}
