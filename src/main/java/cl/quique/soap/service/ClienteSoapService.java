package cl.quique.soap.service;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;

@WebService(
    name = "ClienteSoapService",
    targetNamespace = "http://soap.quique.cl/clientes"
)
public interface ClienteSoapService {

    @WebMethod(operationName = "consultarCliente")
    String consultarCliente(
        @WebParam(name = "idCliente") Long idCliente
    );
}

