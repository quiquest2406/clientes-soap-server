package cl.quique.soap.config;

import cl.quique.soap.service.ClienteSoapServiceImpl;
import jakarta.xml.ws.Endpoint;
import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SoapConfig {

    private final Bus bus;

    public SoapConfig(Bus bus) {
        this.bus = bus;
    }

    @Bean
    public Endpoint clienteEndpoint() {

         System.out.println(">>> REGISTRANDO ENDPOINT SOAP CLIENTES <<<");

        EndpointImpl endpoint = new EndpointImpl(
            bus,
            new ClienteSoapServiceImpl()
        );

        endpoint.publish("/clientes");

        return endpoint;
    }
}
