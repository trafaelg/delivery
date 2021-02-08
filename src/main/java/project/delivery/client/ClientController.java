package project.delivery.client;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/client")

public class ClientController {

	@Autowired
	private ClientService clientService;
		
	@GetMapping
	public ResponseEntity<List<ClientEntity>> listClient(){
		List<ClientEntity> clients=clientService.listClient();
		return ResponseEntity.ok(clients);
	}
		
	@PostMapping
	@Transactional
	public ResponseEntity<ClientEntity> save(@RequestBody ClientEntity client) {
		ClientEntity c = clientService.save(client);
		return ResponseEntity.ok(c);
	}
}