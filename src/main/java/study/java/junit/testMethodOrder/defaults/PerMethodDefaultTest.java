package study.java.junit.testMethodOrder.defaults;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import lombok.extern.slf4j.Slf4j;

/**
 * PER_METHOD + 아무 설정이 없는 경우: 메서드이름 알파벳 순서대로 테스트 수행됨
 */
@Slf4j
@TestInstance(Lifecycle.PER_METHOD)
public class PerMethodDefaultTest {

	@Test
	void d2() {
		log.debug("===> d2");
	}

	@Test
	void a2() {
		log.debug("===> a2");
	}

	@Test
	void b2() {
		log.debug("===> b2");
	}

	@Test
	void d1() {
		log.debug("===> d1");
	}

	@Test
	void a1() {
		log.debug("===> a1");
	}

	@Test
	void b1() {
		log.debug("===> b1");
	}

}
