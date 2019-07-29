package tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.Ordering;

import pages.ProductsPage;

public class SortByNamesAsc extends GenericTest {

	@Test
	public void testProductsAreSortedByAsc() {

		ProductsPage productsPage = openLoginPage().loginAs("standard_user", "secret_sauce").sortByNamesAsc();

		List<String> names = productsPage.getProductsNames();

		Assert.assertTrue(Ordering.natural().isOrdered(names));

	}

}
