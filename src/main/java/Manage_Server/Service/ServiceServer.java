package Manage_Server.Service;

import Manage_Server.Models.Server;

import java.io.IOException;
import java.util.Collection;

public interface ServiceServer {

    Server create(Server server);
    Server ping(String ipAddress) throws IOException;
    Collection<Server> list(int limit);
    Server get(Long id);
    Server update(Server server);
    boolean delete(Long id);
}
