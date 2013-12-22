/**********************************************
 * Constants.java
 * Copyright (c) 2013 Wild Bama Boy.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl.html
 **********************************************/

package spellbound.core;

import net.minecraft.block.Block;
import spellbound.spells.AbstractSurge;
import spellbound.spells.SurgeBackfire;
import spellbound.spells.SurgeCow;
import spellbound.spells.SurgeRiches;

public final class Constants 
{
	public static final String VERSION = "1.0.0";
	
	public static final AbstractSurge[] SURGES = new AbstractSurge[]
			{
		new SurgeRiches(),
		new SurgeBackfire(),
		new SurgeCow()
			};
	
	public static final String[] SPRAY_PARTICLES = new String[]
			{
		"flame", 
		"smoke", 
		"happyVillager", 
		"portal", 
		"splash", 
		"townaura", 
		"reddust"
			};
	
	public static final int[] CROP_IDS = new int[]
			{
		Block.crops.blockID, 
		Block.carrot.blockID, 
		Block.potato.blockID,
		Block.melonStem.blockID, 
		Block.pumpkinStem.blockID
			};

	public static final int[] SNOW_SUPPORTERS = new int[]
			{
		Block.grass.blockID, 
		Block.dirt.blockID, 
		Block.sand.blockID, 
		Block.stone.blockID, 
		Block.cobblestone.blockID
			};
	
	//Colors & formatting
	private static final char SECTION_SIGN = '§';

	public static final String COLOR_BLACK = SECTION_SIGN + "0";
	public static final String COLOR_DARKBLUE = SECTION_SIGN + "1";
	public static final String COLOR_DARKGREEN = SECTION_SIGN + "2";
	public static final String COLOR_DARKAQUA = SECTION_SIGN + "3";
	public static final String COLOR_DARKRED = SECTION_SIGN + "4";
	public static final String COLOR_PURPLE = SECTION_SIGN + "5";
	public static final String COLOR_GOLD = SECTION_SIGN + "6";
	public static final String COLOR_GRAY = SECTION_SIGN + "7";
	public static final String COLOR_DARKGRAY = SECTION_SIGN + "8";
	public static final String COLOR_BLUE = SECTION_SIGN + "9";
	public static final String COLOR_GREEN = SECTION_SIGN + "A";
	public static final String COLOR_AQUA = SECTION_SIGN + "B";
	public static final String COLOR_RED = SECTION_SIGN + "C";
	public static final String COLOR_LIGHTPURPLE = SECTION_SIGN + "D";
	public static final String COLOR_YELLOW = SECTION_SIGN + "E";
	public static final String COLOR_WHITE = SECTION_SIGN + "F";

	public static final String FORMAT_OBFUSCATED = SECTION_SIGN + "k";
	public static final String FORMAT_BOLD = SECTION_SIGN + "l";
	public static final String FORMAT_STRIKE = SECTION_SIGN + "m";
	public static final String FORMAT_UNDERLINE = SECTION_SIGN + "n";
	public static final String FORMAT_ITALIC = SECTION_SIGN + "o";
	public static final String FORMAT_RESET = SECTION_SIGN + "r";
	
	private Constants() { }
}
