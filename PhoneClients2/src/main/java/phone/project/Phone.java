package phone.project;

import java.util.*;
import java.util.*;

public class Phone {
    private final List<Client>clients;
    public Phone(){clients=new ArrayList <Client>();}

    public List<Client>getClients(){
        return clients;
    }


    public void addClient(final Client client){
        clients.add(client);
    }

    public void deleteClient(final Client client){
        clients.remove(client);
    }

    public Client getClient(final String name){
        Client client=null;
        for (Client cl:clients){
            if (name.equalsIgnoreCase(cl.getId())){
                client=cl;
                break;
            }
        }
        return client;
    }
}
