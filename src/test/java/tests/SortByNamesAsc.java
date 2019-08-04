package tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.Ordering;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import pages.ProductsPage;

public class SortByNamesAsc extends GenericTest {

	
	@Feature("Products Sorting")
	@Story("PLH-455")
	@Test
	public void testProductsAreSortedByAsc() {

		ProductsPage productsPage = openLoginPage().loginAs("standard_user", "secret_sauce").sortByNamesAsc();

		List<String> names = productsPage.getProductsNames();

		Assert.assertTrue(Ordering.natural().isOrdered(names));

	}

}
