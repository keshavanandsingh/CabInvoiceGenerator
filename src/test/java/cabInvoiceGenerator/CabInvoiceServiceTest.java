package cabInvoiceGenerator;

import org.junit.Test;
import org.junit.Assert;
import org.junit.Before;

public class CabInvoiceServiceTest {
	CabInvoiceGenerator invoiceGenerator = null;

	@Before
	public void initialize() {
		invoiceGenerator = new CabInvoiceGenerator();
	}

	@Test
	public void givenDistanceAndTime_ShouldReturnTotalFare() {
		double distance = 5.0;
		int time = 10;
		double fare = invoiceGenerator.calculateFare(distance, time);
		Assert.assertEquals(60.0, fare, 0.0);
	}

	@Test
	public void givenDistanceAndTime_WhenFareLessThanMinimumFare_ShouldReturnMinimumFare() {
		double distance = 0.3;
		int time = 1;
		double fare = invoiceGenerator.calculateFare(distance, time);
		Assert.assertEquals(5.0, fare, 0.0);
	}

	@Test
	public void givenMultipleRides_ShouldReturnTotalFare() {
		Ride[] rides = { new Ride(5.0, 10), new Ride(0.3, 1), new Ride(1.0, 5) };
		double totalFare = invoiceGenerator.calculateFare(rides);
		Assert.assertEquals(80.0, totalFare, 0.0);
	}

	@Test
	public void givenMultipleRides_ShouldReturnInvoiceSummary() {
		Ride[] rides = { new Ride(5.0, 10), new Ride(0.3, 1), new Ride(1.0, 5) };
		EnhancedInvoice invoiceSummary = invoiceGenerator.getInvoiceSummary(rides);
		EnhancedInvoice expectedInvoiceSummary = new EnhancedInvoice(3, 80.0);
		Assert.assertEquals(expectedInvoiceSummary, invoiceSummary);
	}
}
