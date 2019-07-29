package tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.Ordering;

import pages.ProductsPage;

public class SortByPriceDesc extends GenericTest {
	
	@Test
	public void testSortByPriceAsc() {
		
		
		
		ProductsPage productsPage = openLoginPage().loginAs("standard_user", "secret_sauce").sortByPriceDesc();
		
		List<Double> prices = productsPage.getProductsPrices();
		
		Assert.assertTrue(Ordering.natural().reverse().isOrdered(prices));

}
	
}
