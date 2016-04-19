package test.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import product.Product;
import database.product.ProductTable;

public class TestAdd{
	ProductTable products = new ProductTable();
	@Test
	public void testAdd(){
		// Add a new product
		Product add = new Product();
		add.setCode("Inser-tAne-wPro-duct");
		add.setName("ForTest");
		add.setPrice(9.99);
		boolean done = products.addProduct(add);
		assertTrue(done==true);
		assertEquals("ForTest", products.searchName("Inser-tAne-wPro-duct"));	
		assertEquals(9.99, products.searchPrice("Inser-tAne-wPro-duct"),0.01);
		
		// Add a existing product
		boolean addFail = products.addProduct(add);
		assertTrue(addFail==false);
	}
	
}
