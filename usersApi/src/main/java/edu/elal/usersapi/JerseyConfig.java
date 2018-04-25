/**
 * 
 */
package edu.elal.usersapi;

import javax.annotation.PostConstruct;
import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

import edu.elal.usersapi.controller.UserController;

/**
 * @author sfacchini
 *
 */
@Configuration
@ApplicationPath("rest")
public class JerseyConfig extends ResourceConfig {
    
	public JerseyConfig() {
		
	}
	
	@PostConstruct
	public void setUp() {
		register(UserController.class);
	}
}
