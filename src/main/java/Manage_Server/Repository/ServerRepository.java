package Manage_Server.Repository;

import Manage_Server.Models.Server;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServerRepository extends JpaRepository<Server, Long> {

    Server findByIpAddess(String ipAddress);
}
