package project.delivery.cart;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.delivery.item.ItemEntity;
import project.delivery.product.ProductEntity;
import project.delivery.product.ProductRepository;

@Service
@Transactional
public class CartService {

	@Autowired
	private CartRepository cartRepository;
	@Autowired
	private ProductRepository productRepository;
	
	public List<CartEntity> listCart() {
		return cartRepository.findAll();
	}

	public CartEntity save(CartEntity c) {
		return cartRepository.save(c);
	}
	
	public double calculateItem(ItemEntity i) {
		ProductEntity p = productRepository.findById(i.getProductId()).get();
		return i.getQuantity()*p.getValue();
	}
	
}
