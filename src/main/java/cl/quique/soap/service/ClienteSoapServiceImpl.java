package cl.quique.soap.service;

import jakarta.jws.WebService;

@WebService(
    endpointInterface = "cl.quique.soap.service.ClienteSoapService",
    serviceName = "ClienteSoapService",
    portName = "ClienteSoapPort",
    targetNamespace = "http://soap.quique.cl/clientes"
)
public class ClienteSoapServiceImpl implements ClienteSoapService {

    @Override
    public String consultarCliente(Long idCliente) {

        if (idCliente == null) {
            return "Debe indicar un ID de cliente";
        }

        return "Cliente encontrado: ID " + idCliente
                + " - Nombre: Juan Pérez";
    }
}
