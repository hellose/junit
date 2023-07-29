package study.java.instance;

import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class InitializationBlock {

	@Slf4j
	private static class Parent {
		private String parentString = "parent 필드 초기화 상태";
		{
			// 인스턴스 초기화 블럭
			log.debug("Parent init block start");
			log.debug("{}", parentString);
		}

		public Parent() {
			log.debug("Parent constructor start");
		}
	}

	private static class Child extends Parent {
		private String childString = "child 필드 초기화 상태";
		{
			// 인스턴스 초기화 블럭
			log.debug("Child init block start");
			log.debug("{}", childString);
		}

		public Child() {
			log.debug("Child constructor start");
		}
	}

	@Test
	void createParent() {
		new Parent();
	}

	@Test
	void createChild() {
		new Child();
	}

	@Test
	void createAnonymousInstance() {
		new Child() {
			{
				log.debug("Anonymous init block start");
			}

		};
	}

}
