import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.demo.entrypoint.entity.Product;
import com.demo.entrypoint.services.ProductsService;
import com.demo.entrypoint.services.ProductsServiceImpl;

public class ProductsServiceTests {
	
	@Test
	public void listProductsNotNull()
    {
		ProductsService productsService = new ProductsServiceImpl();
		
		assertNotNull(productsService.listProducts());
		assertNotNull(productsService.listSortedProducts("price"));
    }
	
	@Test
	public void productsListIsFiltered()
    {
		List<Product> productsList = new ArrayList<Product>(); 
		productsList.add(new Product(1, "category", "name", "description", 10.0, 4, "paymentoption", "deliverymethod"));
		
		ProductsServiceImpl productsService = new ProductsServiceImpl();
		
		assertEquals(productsService.filterListByInventory(productsList).size(), 0);
    }
	
	@Test
	public void productsListIsSortedByPrice()
    {
		ProductsServiceImpl productsService = new ProductsServiceImpl();
		List<Product> testList = productsService.listSortedProducts("price");
		
		assertTrue(testList.get(0).getUnitprice() <= testList.get(1).getUnitprice());
    }
	
	@Test
	public void productsListIsSortedByInventory()
    {	
		ProductsServiceImpl productsService = new ProductsServiceImpl();
		List<Product> testList = productsService.listSortedProducts("inventory");
		
		assertTrue(testList.get(0).getInventory() <= testList.get(1).getInventory());
    }
}
