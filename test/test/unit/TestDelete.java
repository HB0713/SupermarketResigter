package test.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import product.Product;
import database.product.ProductTable;

public class TestDelete{
	ProductTable products = new ProductTable();
	@Test
	public void testAdd(){
		// Delete a product not existed
		Product delete = new Product();
		delete.setCode("Inser-tAne-wPro-duct");
		delete.setName("ForTest");
		delete.setPrice(9.99);
		boolean deleteFail = products.deleteProduct(delete);
		assertTrue(deleteFail==false);
		
		// Delete a existing product
		products.addProduct(delete);
		boolean done = products.deleteProduct(delete);
		assertTrue(done==true);
		assertEquals(null, products.searchName("Inser-tAne-wPro-duct"));	
		assertEquals(0.00, products.searchPrice("Inser-tAne-wPro-duct"),0.01);
	}
}
