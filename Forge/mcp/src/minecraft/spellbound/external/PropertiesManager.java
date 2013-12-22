/**********************************************
 * PropertiesManager.java
 * Copyright (c) 2013 Wild Bama Boy.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl.html
 **********************************************/

package spellbound.external;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Properties;

import spellbound.core.SpellboundCore;

public class PropertiesManager 
{
	public PropertiesList propertiesList = new PropertiesList();
	public File propertiesFile;
	public File storageFolder;

	private final Properties properties;

	public PropertiesManager()
	{
		properties = new Properties();
		storageFolder = new File(SpellboundCore.getInstance().runningDirectory + "/config/Spellbound");
		propertiesFile = new File(SpellboundCore.getInstance().runningDirectory + "/config/Spellbound/ModProps.properties");

		if (!storageFolder.exists())
		{
			storageFolder.mkdirs();
		}

		if (propertiesFile.exists())
		{
			loadProperties();
		}

		else
		{
			saveProperties();
		}
	}

	private void saveProperties()
	{
		SpellboundCore.getInstance().log("Saving Spellbound properties...");
		
		try
		{
			properties.clear();

			for (Field f : PropertiesList.class.getFields())
			{
				String fieldType = f.getType().toString();

				if (fieldType.contains("int"))
				{
					properties.put(f.getName(), f.get(propertiesList).toString());
				}
				
				else if (fieldType.contains("boolean"))
				{
					properties.put(f.getName(),  f.get(propertiesList).toString());
				}
			}
			
			FileOutputStream fos = new FileOutputStream(propertiesFile);
			properties.store(fos, "Change item IDs and mod settings here.");
			fos.close();
		}

		catch (IllegalAccessException e)
		{
			SpellboundCore.getInstance().quitWithException("IllegalAccessException while saving properties. This should not happen.", e);
		}
		
		catch (FileNotFoundException e)
		{
			SpellboundCore.getInstance().quitWithException("FileNotFoundException while saving properties. This should not happen.", e);
		} 
		
		catch (IOException e) 
		{
			SpellboundCore.getInstance().quitWithException("IOException while saving properties. This should not happen.", e);
		}
	}

	private void loadProperties()
	{
		SpellboundCore.getInstance().log("Loading Spellbound properties...");
		
		try
		{
			properties.clear();

			FileInputStream fis = new FileInputStream(propertiesFile);
			properties.load(fis);
			
			for (Field f : PropertiesList.class.getFields())
			{
				String fieldType = f.getType().toString();

				if (fieldType.contains("int"))
				{
					f.set(propertiesList, Integer.parseInt(properties.getProperty(f.getName())));
				}
				
				else if (fieldType.contains("boolean"))
				{
					f.set(propertiesList, Boolean.parseBoolean(properties.getProperty(f.getName())));
				}
			}
		}

		catch (NumberFormatException e)
		{
			SpellboundCore.getInstance().log("NumberFormatException while reading properties. You edited the file incorrectly or a new property has been added. Properties will be reset.");
			reset();
		}
		
		catch (IOException e)
		{
			SpellboundCore.getInstance().log("IOException. Properties file does not exist.");
			saveProperties();
		}
		
		catch (IllegalAccessException e)
		{
			SpellboundCore.getInstance().quitWithException("IllegalAccessException while loading properties. This should not happen", e);
		}
	}
	
	private void reset()
	{
		propertiesList = new PropertiesList();
		saveProperties();
	}
}
