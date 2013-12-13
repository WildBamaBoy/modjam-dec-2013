/**********************************************
 * PropertiesManager.java
 * Copyright (c) 2013 MCA Dev Team.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl.html
 **********************************************/

package spellbound.external;

import java.io.File;

import spellbound.core.SB;

public class PropertiesManager 
{
	public PropertiesList propertiesList = new PropertiesList();
	
	public File propertiesFile;
	public File storageFolder;
	
	public PropertiesManager()
	{
		storageFolder = new File(SB.runningDirectory + "/config/Spellbound");
		propertiesFile = new File(SB.runningDirectory + "/config/Spellbound/ModProps.properties");
		
		if (!storageFolder.exists())
		{
			storageFolder.mkdirs();
		}
	}
}
