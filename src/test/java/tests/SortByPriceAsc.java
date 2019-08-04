package tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.Ordering;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import pages.ProductsPage;

public class SortByPriceAsc extends GenericTest{
	
	
	@Feature("Products Sorting")
	@Story("PLH-455")
	@Test
	public void testSortByPriceAsc() {
		
		
		
		ProductsPage productsPage = openLoginPage().loginAs("standard_user", "secret_sauce").sortByPriceAsc();
		
		List<Double> prices = productsPage.getProductsPrices();
		
		Assert.assertTrue(Ordering.natural().isOrdered(prices));
		
		
		
	}
	
	

}
