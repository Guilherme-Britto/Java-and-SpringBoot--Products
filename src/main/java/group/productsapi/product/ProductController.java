package group.productsapi.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/product")
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getProducts() {
        return productService.getProducts();
    }

    @PostMapping
    public void registerNewProduct (@RequestBody Product product){
        productService.addNewProduct(product);
    }

    @PutMapping(path = "{productId}")
    public void updateProduct(@PathVariable("productId") Long productId, @RequestBody Product productDetails) {
        productService.updateProduct(productId, productDetails);
    }

    @DeleteMapping(path = "{studentId}")
    public void removeProduct (@PathVariable("studentId") Long productId){
        productService.deleteProduct(productId);
    }
}
