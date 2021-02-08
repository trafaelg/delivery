package project.delivery.address;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class AddressService {

	@Autowired
	private AddressRepository addressRepository;
	public List<AddressEntity> listAddress() {
		return addressRepository.findAll();
	}

	public AddressEntity save(AddressEntity a) {
		return addressRepository.save(a);
	}
}