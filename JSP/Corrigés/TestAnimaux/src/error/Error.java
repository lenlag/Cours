package error;

import javax.servlet.http.HttpSession;

public class Error {
	private static final String ERROR_KEY="__ERROR";
	
	public void addError(HttpSession session,ErrorEnum msg) {
		session.setAttribute(ERROR_KEY, msg);
	}
	public void clearError(HttpSession session) {
		session.removeAttribute(ERROR_KEY);
	}
	public String getError(HttpSession session) {
		ErrorEnum error = (ErrorEnum)session.getAttribute(ERROR_KEY);
		if (error == null) {
			error = ErrorEnum.DEFAULT;
		}
		return error.getMsg();
	}
}
