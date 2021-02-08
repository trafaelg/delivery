package project.delivery.client;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ClientService {

	@Autowired
	private ClientRepository clientRepository;
	public List<ClientEntity> listClient() {
		return clientRepository.findAll();
	}

	public ClientEntity save(ClientEntity c) {
		return clientRepository.save(c);
	}
}