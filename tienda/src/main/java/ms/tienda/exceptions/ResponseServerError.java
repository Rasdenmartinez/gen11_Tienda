package ms.tienda.exceptions;


import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Data
@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class ResponseServerError extends RuntimeException {
    private String Error = "No es posible procesar la solicitud: Si el problema persiste favor de contactar al Administrador";

    public ResponseServerError(){}

    public ResponseServerError(String mensaje){
        super(mensaje);
    }
}


