package controller.Exeption;

import java.io.IOException;

public class PdfException extends IOException {

    public PdfException(String message) {
        super(message);
    }

    public PdfException(String message, Throwable cause) {
        super(message, cause);
    }

    public PdfException(Throwable cause) {
        super(cause);
    }

    @Override
    public String getMessage() {
        return super.getMessage() + (getCause() != null ? " (" + getCause().getMessage() + ")" : "");
    }

}