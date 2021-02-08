package project.delivery.product;

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
@RequestMapping("/product")

public class ProductController {

	@Autowired
	private ProductService productService;

	@GetMapping
	public ResponseEntity<List<ProductEntity>> listProduct() {
		List<ProductEntity> products = productService.listProduct();
		return ResponseEntity.ok(products);
	}

	@PostMapping
	@Transactional
	public ResponseEntity<ProductEntity> save(@RequestBody ProductEntity product) {
		ProductEntity p = productService.save(product);
		return ResponseEntity.ok(p);
	}
}