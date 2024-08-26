package ms.tienda.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResponseNotFound extends RuntimeException{
    private String mensaje;

    public ResponseNotFound(){
    }

    public ResponseNotFound(String mensaje) {
        super(mensaje);
    }
}
