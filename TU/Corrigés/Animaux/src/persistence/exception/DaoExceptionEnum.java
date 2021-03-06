package persistence.exception;

public enum DaoExceptionEnum {
	IncorrectCfg("Bad cfg file"),
	MoreThanOne("More than One return"),
	ConnectionNull("Connection null");
	
	private String text;
	private DaoExceptionEnum(String text) {
		this.text = text;
	}
	public String getText() {
		return text;
	}
}
