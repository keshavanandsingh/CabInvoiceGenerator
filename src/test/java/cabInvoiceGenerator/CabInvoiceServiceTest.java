package cabInvoiceGenerator;

import org.junit.Test;
import org.junit.Assert;

public class CabInvoiceServiceTest {
	@Test
	public void givenDistanceAndTime_ShouldReturnTotalFare() {
		CabInvoiceGenerator invoiceGenerator = new CabInvoiceGenerator();
		double distance = 5.0;
		int time = 10;
		double fare = invoiceGenerator.calculateFare(distance, time);
		Assert.assertEquals(60.0, fare, 0.0);
	}
}
