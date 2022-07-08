package demo_springjwt.demo.exception;

public class ExpiredException extends Exception {

	private static final long serialVersionUID = -2556322490055461261L;

	public ExpiredException(String errorMessage) {
		super(errorMessage);
	}
	
	public ExpiredException(String errorMessage, Throwable err) {
		super(errorMessage, err);
	}

}