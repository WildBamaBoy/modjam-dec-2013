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
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Properties;

import spellbound.core.SB;

public class PropertiesManager 
{
	public PropertiesList propertiesList = new PropertiesList();

	public File propertiesFile;
	public File storageFolder;
	private Properties properties;

	public PropertiesManager()
	{
		properties = new Properties();
		storageFolder = new File(SB.runningDirectory + "/config/Spellbound");
		propertiesFile = new File(SB.runningDirectory + "/config/Spellbound/ModProps.properties");

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
		//TODO
		System.out.println(">>>>>>>>>>> SAVE");
		try
		{
			properties.clear();

			for (Field f : PropertiesList.class.getFields())
			{
				String fieldType = f.getType().toString();

				if (fieldType.contains("int"))
				{
					properties.put(f.getName(), f.get(properties).toString());
				}

				//TODO EXTEND!!!
			}
			
			FileOutputStream fos = new FileOutputStream(propertiesFile);
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

				//TODO EXTEND!!!
			}
			
			FileOutputStream fos = new FileOutputStream(propertiesFile);
		}

		catch (IOException e)
		{
			//TODO
			//IOEXCEPTION WHEN NOT EXIST
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
