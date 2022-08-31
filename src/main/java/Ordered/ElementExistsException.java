package Ordered;

public class ElementExistsException extends RuntimeException {

    public ElementExistsException() {
        super();
    }

    public ElementExistsException(String mes, Throwable cause, boolean str, boolean str1) {
        super(mes, cause, str, str1);
    }

    public ElementExistsException(String mes, Throwable cause) {
        super(mes, cause);
    }

    public ElementExistsException(String mes) {
        super(mes);
    }

    public ElementExistsException(Throwable cause) {
        super(cause);
    }


}
