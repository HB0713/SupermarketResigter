package database.product;

import java.util.HashMap;

import product.Product;

public class ProductTable {
	private HashMap<String, Product> table;
	
	//Constructor
	public ProductTable(){
		table = new HashMap<String, Product>();
		
		// Initiate product table
		Product p1 = new Product();
		Product p2 = new Product();
		Product p3 = new Product();
		Product p4 = new Product();
		Product p5 = new Product();
		
		p1.setCode("A12T-4GH7-QPL9-3N4M");
		p1.setName("Cereal");
		p1.setPrice(3.46);
		
		p2.setCode("E5T6-9UI3-TH15-QR88");
		p2.setName("Chicken");
		p2.setPrice(8.18);
		
		p3.setCode("YRT6-72AS-K736-L4AR");
		p3.setName("Pop");
		p3.setPrice(1.63);
		
		p4.setCode("TQ4C-VV6T-75ZX-1RMR");
		p4.setName("Pizza");
		p4.setPrice(6.78);
		
		p5.setCode("65P1-UDGM-XH2M-LQW2");
		p5.setName("Tuna");
		p5.setPrice(5.89);
		
		table.put(p1.getCode(),p1);
		table.put(p2.getCode(),p2);
		table.put(p3.getCode(),p3);
		table.put(p4.getCode(),p4);
		table.put(p5.getCode(),p5);
	}
	
	// Add new product
	public boolean addProduct(Product product){
		if(table.containsKey(product.getCode().toUpperCase())){
			System.out.println("Product existed!");
			return false;
		} 
		else{
			table.put(product.getCode().toUpperCase(),product);
			System.out.println("New product added.");
			return true;
		}
	}
	
	// Update existing product
	public boolean updateProduct(Product product){
		if(!table.containsKey(product.getCode().toUpperCase())){
			System.out.println("Cann't find the item!");
			return false;
		}
		else{
			table.put(product.getCode().toUpperCase(),product);
			System.out.println("Product updated.");
			return true;
		}
	}
	
	//Delete existing product
	public boolean deleteProduct(Product product){
		if(table.containsKey(product.getCode().toUpperCase())){
			table.remove(product.getCode().toUpperCase());
			System.out.println("Product deleted.");
			return true;
		}else{
			System.out.println("Cann'y find the item!");
			return false;
		} 
	}
	
	// Look up the price 
	public double searchPrice(String code){
		if(table.containsKey(code.toUpperCase())) return table.get(code.toUpperCase()).getPrice();
		else{
			System.out.println("Cann't find the item and price! " + code);
			return 0.00;
		}
	}
	
	// Look up the name 
	public String searchName(String code){
		if(table.containsKey(code.toUpperCase())) return table.get(code.toUpperCase()).getName();
		else{
			System.out.println("Cann't find the item and name! " + code);
			return null;
		}
	}
	
}
