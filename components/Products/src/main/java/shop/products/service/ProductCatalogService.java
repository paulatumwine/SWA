package shop.products.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shop.products.domain.Product;
import shop.products.domain.Stock;
import shop.products.repository.ProductRepository;

import java.util.Optional;

@Service
public class ProductCatalogService {
	@Autowired
	ProductRepository productRepository;

	public void addProduct(String productnumber, String description, double price) {
		Product product = new Product(productnumber, description,  price);
		productRepository.save(product);
		
	}
	public ProductDTO getProduct(String productnumber) {
		Optional<Product> result = productRepository.findById(productnumber);
		if (result.isPresent())
		  return ProductAdapter.getProductDTO(result.get());
		else
			return null;
	}
	public void setStock(String productnumber, int quantity, String locationcode) {
		Optional<Product> result = productRepository.findById(productnumber);
		if (result.isPresent()) {
			Product product = result.get();
			Stock stock = new Stock(quantity, locationcode);
			product.setStock(stock);
			productRepository.save(product);
		}		
	}
	public void setStock(String productNumber, Integer quantity) {
        Optional<Product> result = productRepository.findById(productNumber);
        if (result.isPresent()) {
            Product product = result.get();
            if (product.getStock() != null) {
                product.getStock().updateQuantity(quantity);
                productRepository.save(product);
            }
        }
    }
}
