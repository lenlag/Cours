package error;

public enum ErrorEnum {
	DEFAULT("Une erreur inconnue est arrivée"),
	LOGIN_PWD_EMPTY("Login ou password vides"),
	LOGIN_PWD_BAD("Login ou password incorrects"),
	CMD_EMPTY("Pas de parametre cmd"),
	AGE_ERROR ("Age incorrect"),
	AGE_EMPTY ("Age vide"),
	NOM_EMPTY ("Nom vide"),
	NOM_PRENOM_AGE_EMPTY ("Age ou prenom ou nom vides"),
	PRENOM_EMPTY ("Prenom vide");
	private String msg;
	private ErrorEnum(String msg) {
		this.msg = msg;
	}
	public String getMsg() {
		return msg;
	}
}
