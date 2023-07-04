package study.java.junit.testMethodOrder.order;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.TestMethodOrder;

import lombok.extern.slf4j.Slf4j;

/**
 * PER_METHOD + 순서지정 어노테이션
 */
@Slf4j
@TestInstance(Lifecycle.PER_METHOD)
// Order 어노테이션을 사용하여 테스트 메서드의 순서를 지정하는 테스트 클래스임을 선언
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PerMethodTestMethodOrderTest2 {

	@Test
	// 테스트 메서드에 Order 어노테이션을 사용
	@Order(100)
	void d2() {
		log.debug("===> d2");
	}

	@Test
	@Order(300)
	void a2() {
		log.debug("===> a2");
	}

	@Test
	@Order(400)
	void b2() {
		log.debug("===> b2");
	}

	@Test
	@Order(200)
	void d1() {
		log.debug("===> d1");
	}

	@Test
	@Order(600)
	void a1() {
		log.debug("===> a1");
	}

	@Test
	@Order(500)
	void b1() {
		log.debug("===> b1");
	}

}
