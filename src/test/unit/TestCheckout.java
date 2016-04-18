package test.unit;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import checkout.product.Checkout;

@RunWith(value = Parameterized.class)
public class TestCheckout {
	private double price;
	private String items;
	
	//parameters pass via this constructor
	public TestCheckout(double price, String items){
		this.price=price;
		this.items=items;
	}
	
	// Declare parameters here
	@Parameters()
	public static Iterable<Object[]> data(){
		return Arrays.asList(new Object[][]{
				{0.00, ""},
				{0.00, "xxxx-xxxx-xxxx-xxxx"},
				{3.76, "A12T-4GH7-QPL9-3N4M"},
				{5.54, "A12T-4GH7-QPL9-3N4M;YRT6-72AS-K736-L4AR"},
				{11.94, "A12T-4GH7-QPL9-3N4M;YRT6-72AS-K736-L4AR;65P1-UDGM-XH2M-LQW2"},
				{20.84, "A12T-4GH7-QPL9-3N4M;E5T6-9UI3-TH15-QR88;YRT6-72AS-K736-L4AR;65P1-UDGM-XH2M-LQW2"},
				{28.21, "A12T-4GH7-QPL9-3N4M;E5T6-9UI3-TH15-QR88;YRT6-72AS-K736-L4AR;TQ4C-VV6T-75ZX-1RMR;65P1-UDGM-XH2M-LQW2"},
				{28.21, "a12t-4gh7-qpl9-3n4m;e5t6-9ui3-TH15-Qr88;yRt6-72AS-k736-L4Ar;tQ4C-VV6T-75zx-1RMr;65p1-udgm-xh2m-lqw2"} // items code with lower case
		});
	}
	
	@Test
	public void testCheckout(){
		Checkout checkout = new Checkout();
		assertEquals(price,checkout.checkout(items),0.01); //Math.abs(expected - actual) < epsilon, where expected=price and epsilon=0.01
	}
}
