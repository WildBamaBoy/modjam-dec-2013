/**********************************************
 * SB.java
 * Copyright (c) 2013 MCA Dev Team.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl.html
 **********************************************/

package spellbound.core;

import spellbound.external.PropertiesManager;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;

@Mod(modid="Spellbound", name="Spellbound", version="1.0.0")
@NetworkMod(clientSideRequired=true, serverSideRequired=false,
channels={"CHANNEL"}
//packethandler = Packethandler.class //*
)
public class SB 
{
	@Instance("Spellbound")
	public static SB instance;
	public static PropertiesManager propertiesManager;
	public static String runningDirectory;
	
	//Items here
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		instance = this;
		runningDirectory = System.getProperty("user.dir");
		propertiesManager = new PropertiesManager();
	}
}
