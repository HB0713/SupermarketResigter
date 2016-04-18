package test.unit;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import checkout.product.Checkout;

@RunWith(value = Parameterized.class)
public class TestTax {
	private double tax;
	private String items;
	
	//parameters pass via this constructor
	public TestTax(double tax, String items){
		this.tax=tax;
		this.items=items;
	}
	
	// Declare parameters here
	@Parameters()
	public static Iterable<Object[]> data(){
		return Arrays.asList(new Object[][]{
				{0.00, ""},
				{0.00, "xxxx-xxxx-xxxx-xxxx"},
				{0.30, "A12T-4GH7-QPL9-3N4M"},
				{0.45, "A12T-4GH7-QPL9-3N4M;YRT6-72AS-K736-L4AR"},
				{0.96, "A12T-4GH7-QPL9-3N4M;YRT6-72AS-K736-L4AR;65P1-UDGM-XH2M-LQW2"},
				{1.68, "A12T-4GH7-QPL9-3N4M;E5T6-9UI3-TH15-QR88;YRT6-72AS-K736-L4AR;65P1-UDGM-XH2M-LQW2"},
				{2.27, "A12T-4GH7-QPL9-3N4M;E5T6-9UI3-TH15-QR88;YRT6-72AS-K736-L4AR;TQ4C-VV6T-75ZX-1RMR;65P1-UDGM-XH2M-LQW2"},
				{2.27, "a12t-4gh7-qpl9-3n4m;e5t6-9ui3-TH15-Qr88;yRt6-72AS-k736-L4Ar;tQ4C-VV6T-75zx-1RMr;65p1-udgm-xh2m-lqw2"} // items code with lower case
		});
	}
	
	@Test
	public void testTax(){
		Checkout checkout = new Checkout();
		assertEquals(tax,checkout.calTax(items),0.01); //Math.abs(expected - actual) < epsilon, where expected=tax and epsilon=0.01
	}
}
