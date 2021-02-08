package project.delivery.cart;

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
@RequestMapping("/cart")
public class CartController {

	@Autowired
	private CartService cartService;
		
	@GetMapping
	public ResponseEntity<List<CartEntity>> listCart(){
		List<CartEntity> cart=cartService.listCart();
		return ResponseEntity.ok(cart);
	}
		
	@PostMapping
	@Transactional
	public ResponseEntity<CartEntity> save(@RequestBody CartEntity cart) {
		int totalValue = 0;
		for(int i = 0; i < cart.getItens().size(); i++) {
			totalValue += cartService.calculateItem(cart.getItens().get(i));
		}
		
		cart.setTotal(totalValue);
		
		CartEntity c = cartService.save(cart);
		return ResponseEntity.ok(c);
	}
	
}
