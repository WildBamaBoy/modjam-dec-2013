package spellbound.enums;

public enum EnumItemInUseTime 
{
	INSTANT(0, "Instant"),
	ONE_SECOND(10, "1 second"),
	TWO_SECONDS(20, "2 seconds"),
	THREE_SECONDS(40, "3 seconds"),
	FOUR_SECONDS(60, "4 seconds"),
	FIVE_SECONDS(80, "5 seconds");
	
	private int value;
	private String displayString;
	
	private EnumItemInUseTime(int value, String displayString)
	{
		this.value = value;
		this.displayString = displayString;
	}
	
	public int getValue()
	{
		return value;
	}
	
	public String getDisplayString()
	{
		return displayString;
	}
}
