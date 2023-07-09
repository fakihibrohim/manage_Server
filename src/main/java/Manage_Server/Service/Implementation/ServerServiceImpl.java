package Manage_Server.Service.Implementation;

import Manage_Server.Models.Server;
import Manage_Server.Repository.ServerRepository;
import Manage_Server.Service.ServiceServer;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.InetAddress;
import java.util.Collection;

import static Manage_Server.enumation.Status.SERVER_DOWN;
import static Manage_Server.enumation.Status.SERVER_UP;
import static java.lang.Boolean.TRUE;
import static org.springframework.data.domain.PageRequest.*;
import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RequiredArgsConstructor
@Service
@Transactional
@Slf4j
public class ServerServiceImpl implements ServiceServer {

    public final ServerRepository serverRepository;

    @Override
    public Server create(Server server) {
        log.info("Saving new server : {}", server.getName());
        server.setImageURL(setServerImageURL());
        return serverRepository.save(server);
    }

    @Override
    public Server ping(String ipAddress) throws IOException {
        log.info("Pinging server IP : {}", ipAddress);
        Server server = serverRepository.findByIpAddess(ipAddress);
        InetAddress address = InetAddress.getByName(ipAddress);
        server.setStatus(address.isReachable(10000)? SERVER_UP : SERVER_DOWN);
        serverRepository.save(server);
        return server;
    }

    @Override
    public Collection<Server> list(int limit) {
        log.info("Fatching server by id : {}", id);
        return serverRepository.findAll(of(0, limit)).toList();
    }

    @Override
    public Server get(Long id) {
        return serverRepository.findById(id).get();
    }

    @Override
    public Server update(Server server) {
        log.info("Updating server : {}", server.getName());
        return serverRepository.save(server);
    }

    @Override
    public boolean delete(Long id) {
        log.info("Deleting Server by ID : {}", id);
        serverRepository.deleteById(id);
        return TRUE;
    }

    private String setServerImageURL() {
        return null;
    }
}
