package checkout.product;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import database.product.ProductTable;
import product.Product;

public class Checkout {
	private ProductTable products = new ProductTable();
	
	// return final price
	public double checkout(String items){
		double price = 0.00;
		double taxRate = 0.0875;
		String[] codes = items.split(";");
		for(String item:codes){
			if(products.searchName(item)==null){
				System.out.println("item error!");
			}else{
				System.out.println(products.searchName(item) + ": $" + products.searchPrice(item));
			}
			price += products.searchPrice(item);
		}
		// set the precision to two. Example: $1.2345 -> $1.23 
		Double finalPrice = new BigDecimal(price*(1+taxRate)).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		return finalPrice;
	}
	
	// return tax
	public double calTax(String items){
		double price = 0.00;
		double taxRate = 0.0875;
		String[] codes = items.split(";");
		for(String item:codes){
			price += products.searchPrice(item);
		}
		// set the precision to two. Example: $1.2345 -> $1.23 
		Double tax = new BigDecimal(price*taxRate).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		return tax;
	}
	
	public static void main(String[] args){
		Checkout total = new Checkout();
		String items = "A12T-4GH7-QPL9-3N4M;YRT6-72AS-K736-L4AR;65P1-UDGM-XH2M-LQW2";
		double tax = total.calTax(items);
		double price = total.checkout(items);
		System.out.println("Tax is: $" + tax);
		System.out.println("Total price is: $" + price);	
	}
}

