package fr.afpa.stage.tools;

public enum Mp3Lengths {
	TAG_ZONE_SIZE(128),
	TAG_LEN(3),
	TITLE_LEN(30),
	AUTHOR_LEN(30),
	ALBUM_LEN(30),
	YEAR_LEN(4),
	COMMENT_LEN(30),
	STYLE_LEN(1);
	
	private int value;
	
	Mp3Lengths(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}
	
	public static void main(String[] args) {
		System.out.println(TAG_ZONE_SIZE+" ordinal = "+TAG_ZONE_SIZE.ordinal()+" name = "+TAG_ZONE_SIZE.name()+" valeur = "+TAG_ZONE_SIZE.getValue());
	}
}
