package project.delivery.product;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	public List<ProductEntity> listProduct() {
		return productRepository.findAll();
	}

	public ProductEntity save(ProductEntity c) {
		return productRepository.save(c);
	}
}