package study.java.junit.testInstance;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
public class LifecyclePerClass {

	private int count;

	public LifecyclePerClass() {
		System.out.println("===> constructor: " + this.hashCode());
	}

	@BeforeEach
	void beforeEach() {
		System.out.println("===> beforeEach");
	}

	@AfterEach
	void afterEach() {
		System.out.println("===> afterEach");
		System.out.println(count);
	}

	@Test
	void test1() {
		System.out.println("===> test1");
		count = 100;
	}

	@Test
	void test2() {
		System.out.println("===> test2");
	}
}
