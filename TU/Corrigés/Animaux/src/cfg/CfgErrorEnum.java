package cfg;

public enum CfgErrorEnum {
	No_File("No Cfg File found");
	private String error;
	private CfgErrorEnum(String error) {
		this.error = error;
	}
	public String getError() {
		return error;
	}
}
