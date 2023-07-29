package study.java._interface.funtionalinterface;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ImplicitTypeInference {

	@Test
	@DisplayName("람다식의 타입을 정의하지 않아도 암시적 타입 추론을 통해 해당 타입 인스턴스가 생성된다.")
	void implicitTypeInference() {
		FuncInter1 one = () -> {
		};
		assertInstanceOf(FuncInter1.class, one);
	}

	@Test
	@DisplayName("함수형 인터페이스 타입 간 메서드 시그니처가 동일하다라고 해서 형변환이 가능한 것은 아니다")
	void sameLambdaSignatureButClassCastImpossible() {
		FuncInter1 one = () -> {
		};
		assertThrows(ClassCastException.class, () -> {
			FuncInter2 two = (FuncInter2) one;
		});
	}

	@Test
	@DisplayName("Object타입으로 변수 선언시 타입 추론이 안되기 때문에 함수형 인터페이스 타입으로 먼저 정의한 뒤 Object형으로 변경필요")
	void test() {
		assertDoesNotThrow(() -> {
			// Object one = (Object) (() -> {}); // 암시적 타입 추론 불가능 -> compile 에러
			Object obj = (Object) (FuncInter1) (() -> {
			});
		});
	}

}