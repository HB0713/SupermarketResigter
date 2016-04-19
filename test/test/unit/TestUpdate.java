package test.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import product.Product;
import database.product.ProductTable;

public class TestUpdate{
	ProductTable products = new ProductTable();
	@Test
	public void testAdd(){
		// update an product not existed
		Product none = new Product();
		none.setCode("none-none-none-none");
		none.setName("none");
		none.setPrice(0.01);
		boolean updateFail = products.updateProduct(none);
		assertTrue(updateFail==false);

		// update an existing product
		Product test = new Product();
		test.setCode("A12T-4GH7-QPL9-3N4M");
		test.setName("TestUpdate");
		test.setPrice(0.01);
		boolean start = products.updateProduct(test);
		assertTrue(start==true);
		assertEquals("TestUpdate", products.searchName("A12T-4GH7-QPL9-3N4M"));	
		assertEquals(0.01, products.searchPrice("A12T-4GH7-QPL9-3N4M"),0.01);
		
		// restore the product
		Product reset = new Product();
		reset.setCode("A12T-4GH7-QPL9-3N4M");
		reset.setName("Cereal");
		reset.setPrice(3.46);
		boolean done = products.updateProduct(reset);
		assertTrue(done==true);
		assertEquals("Cereal", products.searchName("A12T-4GH7-QPL9-3N4M"));	
		assertEquals(3.46, products.searchPrice("A12T-4GH7-QPL9-3N4M"),0.01);
	}
}
