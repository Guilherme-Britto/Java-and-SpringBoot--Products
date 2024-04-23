package group.productsapi.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    public void addNewProduct(Product product) {
        Optional<Product> foundProduct = productRepository
                .findProductByCode(product.getCode());
        if (foundProduct.isPresent()){
            throw new IllegalStateException("code taken");
        }
        productRepository.save(product);
    }

    public void deleteProduct(Long productId) {
        System.out.println(productId.getClass().getName());
        boolean exists = productRepository.existsById(productId);
        System.out.println(exists);

        if (!exists){
            throw new IllegalStateException("Product with id " + productId + " does not exists");
        }
        productRepository.deleteById(productId);
    }

    public void updateProduct(Long productId, Product productDetails) {
        Product existingProduct = productRepository.findById(productId)
                .orElseThrow(() -> new IllegalStateException("Product with id " + productId + " does not exist"));

        if (!existingProduct.getCode().equals(productDetails.getCode())) {
            Optional<Product> existingProductWithCode = productRepository.findProductByCode(productDetails.getCode());
            if (existingProductWithCode.isPresent()) {
                throw new IllegalStateException("Product with code " + productDetails.getCode() + " already exists");
            }
        }

        if (productDetails.getCode() != null) {
            existingProduct.setCode(productDetails.getCode());
        }
        if (productDetails.getDescription() != null) {
            existingProduct.setDescription(productDetails.getDescription());
        }
        if (productDetails.getPrice() != null) {
            existingProduct.setPrice(productDetails.getPrice());
        }

        productRepository.save(existingProduct);
    }

}