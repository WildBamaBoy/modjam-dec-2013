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
			saveProperties();
		}

		else
		{
			loadProperties();
		}
	}

	private void saveProperties()
	{
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
			properties.store(fos, "Change item IDs");
			fos.close();
		}

		catch (IllegalAccessException e)
		{
			//TODO Crash handler
			System.out.println("ILLEGAL ACCESS");
		}
		
		catch (FileNotFoundException e)
		{
			//TODO Crash handler
			System.out.println("FILE NOT FOUND");
		} 
		
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void loadProperties()
	{
		System.out.println(">>>>>>>>>>> LOAD");
		
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
					f.set(propertiesList, properties.getProperty(f.getName()));
				}
				
				else if (fieldType.contains("boolean"))
				{
					f.set(propertiesList, properties.getProperty(f.getName()));
				}
			}
		}

		catch (IOException e)
		{
			//When the file does not exist.
			saveProperties();
		}
		
		catch (IllegalAccessException e)
		{
			//TODO Crash handler
			System.out.println("ILLEGAL ACCESS");
		}
	}
	
	private void reset()
	{
		propertiesList = new PropertiesList();
		saveProperties();
	}
}
