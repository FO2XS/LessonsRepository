package registration;

import javax.xml.ws.Endpoint;
import service.endpoint.MessageService;
import service.endpoint.TovarService;

public class PublicWS {
    public static void main(String[] argv){
        Endpoint.publish("http://localhost:8080/ws01/MessageService", new MessageService());
        Endpoint.publish("http://localhost:8080/ws02/TovarService", new TovarService());
        System.out.println("Server is running");
    }
}
