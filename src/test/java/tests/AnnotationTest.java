package tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class AnnotationTest {

	@BeforeSuite
	public void beforeSuite() {

		System.out.println("Before Suite");
	}

	@BeforeClass
	public void beforeClass() {

		System.out.println("Before Class");
	}

	@BeforeMethod
	public void beforeMethod() {

		System.out.println("Before Method");
		throw new IllegalStateException("Test ex"); // присусово викликаємо ексепшн
	}

	@Test
	public void test() {

		System.out.println("Test");
		
	}

	@AfterMethod
	public void afterMethod() {

		System.out.println("After Method");
	}

	@AfterClass
	public void afterClass() {

		System.out.println("After Class");
	}

	@AfterSuite
	public void afterSuite() {

		System.out.println("After Suite");
	}

}
