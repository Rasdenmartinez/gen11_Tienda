package ms.tienda.exceptions;

import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Data
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResponseNotFound extends RuntimeException{
    private String mensaje = "La consulta no arrojo ningun resultado";
    private String Error = "El elemento solicitado no existe";

    public ResponseNotFound(){
    }

    public ResponseNotFound(String Error) {
        super(Error);
    }

}

