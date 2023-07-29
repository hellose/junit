package study.java.try_catch_finally.returnTest;

import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
class ReturnInTryCatchFinally {

	/*
	 * 예외 발생X (try의 return에 도달한 경우)
	 */
	@Test
	void test1() {
		log.debug("getReturn1: {}\n", getReturn1());
	}

	static String getReturn1() {
		String str = "do";
		try {
			str = "Try";
			log.debug(str);

			// 1. try에서 return문을 만나면 리턴값을 임시저장
			return str;
			// 3. finally의 수행이 끝나면 try에서 임시 저장된 리턴값 리턴
		} catch (Exception e) {
			str = "Catch";
			log.debug(str);
			return str;
		} finally {
			// 2. finally 수행
			str = "Finally";
			log.debug(str);
		}
	}

	@Test
	void test2() {
		log.debug("getReturn2: {}\n", getReturn2());
	}

	static String getReturn2() {
		String str = "do";
		try {
			str = "Try";
			log.debug(str);

			// 1. try에서 return문을 만나면 리턴값을 임시저장
			return str;
		} catch (Exception e) {
			str = "Catch";
			log.debug(str);
			return str;
		} finally {
			// 2. finally 수행
			str = "Finally";
			log.debug(str);
			// 3. finally의 return이 우선순위가 더 높음
			
			// finally안에서 리턴시키는 것은 경고가 뜨는데, 이는 만약 try문에서 리턴값을 가진채로 finally로 넘어오면 두 리턴값이 충돌할 수 있기 때문
			return str;
		}
	}

	/*
	 * 예외 발생O (try의 return에 도달하지 못한 경우)
	 */
	@Test
	void test3() {
		log.debug("getReturn3: {}\n", getReturn3());
	}

	static String getReturn3() {
		String str = "do";
		try {
			str = "Try";
			log.debug(str);
			
			int i = 0 / 0; //ArithmeticException
			// 1. ArithmeticException 발생 -> catch로 이동
			
			return str;
		} catch (ArithmeticException e) {
			// 2. catch 수행
			str = "Catch";
			log.debug(str);
			// 3. catch에서 리턴될 값 임시저장 후 -> finally로 이동
			
			// 5. catch에서 임시저장된 값 리턴
			return str;
		} finally {
			// 4. finally 수행
			str = "Finally";
			log.debug(str);
		}
	}
	
	@Test
	void test4() {
		log.debug("getReturn4: {}\n", getReturn4());
	}

	static String getReturn4() {
		String str = "do";
		try {
			str = "Try";
			log.debug(str);
			
			int i = 0 / 0; //ArithmeticException
			// 1. ArithmeticException 발생 -> catch로 이동
			
			return str;
		} catch (ArithmeticException e) {
			// 2. catch 수행
			str = "Catch";
			log.debug(str);
			// 3. catch에서 리턴될 값 임시저장 후 -> finally로 이동
			
			return str;
		} finally {
			// 4. finally 수행
			str = "Finally";
			log.debug(str);
			// 5. finally의 return이 우선순위가 더 높음
			return str;
		}
	}
	
	@Test
	void test5() {
		log.debug("getReturn5: {}\n", getReturn5());
	}

	static String getReturn5() {
		String str = "do";
		try {
			str = "Try";
			log.debug(str);
			
			int i = 0 / 0; //ArithmeticException
			// 1. ArithmeticException 발생 -> catch로 이동
			
			return str;
		} catch (ArithmeticException e) {
			// 2. catch 수행
			str = "Catch";
			log.debug(str);
			
			throw e;
		} finally {
			// 3. finally 수행
			str = "Finally";
			log.debug(str);
			// 4. finally에 return문 존재 -> catch의 throw e; 는 무시됨
			return str;
		}
	}

}
