package com.douzone.container.user.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

import com.douzone.container.user.User;
import com.douzone.container.user.User1;

public class XmlConfigTest {

	public static void main(String[] args) {
		// XML Auto Confinguration(Annotation Scanning)
		// testBeanFactory01();
		
		// XML Bean Confinguration(Explicit Configuration)
		// testBeanFactory02();
		
		// XML Auto Confinguration(Annotation Scanning)
		// testApplicationContext01();
		
		// XML Bean Confinguration(Explicit Configuration)
		//testApplicationContext02();
		
		// XML Bean Confinguration(Explicit Configuration)
		testApplicationContext03();
	}
	
	// XML Bean Confinguration(Explicit Configuration)
	private static void testApplicationContext03() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("com/douzone/container/config/user/applicationContext02.xml");
		User user = null;
		// Id로 Bean 가져오기
		user = (User) ac.getBean("user");
		System.out.println(user);
		
		// name으로 Bean 가져오기
		user = (User) ac.getBean("usr");
		System.out.println(user);
		
		// Type으로 Bean 가져오기
		// 같은 Type의 Bean이 두개 이상 있으면 Type으로 가져오면 Error가 발생한다
		// 해결방법 1. id + type
		user = ac.getBean("user2", User.class);
		System.out.println(user);
		
		// 해결방법 2. name + type
		user = ac.getBean("usr2", User.class);
		System.out.println(user);
		
		// 2개의 파라미터로 생성된 Bean 가져오기 ①
		user = ac.getBean("user3", User.class);
		System.out.println(user);
		
		// 2개의 파라미터로 생성된 Bean 가져오기 ②
		user = ac.getBean("user4", User.class);
		System.out.println(user);
		
		// setter를 사용한 Bean 가져오기 ①
		user = ac.getBean("user5", User.class);
		System.out.println(user);
		
		// setter를 사용한 Bean 가져오기 ② (DI)
		user = ac.getBean("user6", User.class);
		System.out.println(user);
		
		// setter를 사용한 Bean 가져오기 ③ (List Property)
		user = ac.getBean("user7", User.class);
		System.out.println(user);
	}
	
	// XML Bean Confinguration(Explicit Configuration)
	private static void testApplicationContext02() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("com/douzone/container/config/user/applicationContext02.xml");
		
		// Type으로 Bean 가져오기
		User1 user1 = ac.getBean(User1.class);
		System.out.println(user1.getName());

		// Id로 Bean 가져오기
		user1 = (User1) ac.getBean("user1");
		System.out.println(user1.getName());
	}
		
	// XML Auto Confinguration(Annotation Scanning)
	private static void testApplicationContext01() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("com/douzone/container/config/user/applicationContext01.xml");
		
		User1 user1 = ac.getBean(User1.class);
		System.out.println(user1.getName());
		
		// Bean Id가 자동으로 설정된다.
		user1 = (User1)ac.getBean("user1");
		System.out.println(user1.getName());
	}

	// XML Auto Confinguration(Annotation Scanning)
	private static void testBeanFactory01() {
		BeanFactory bf = new XmlBeanFactory(new ClassPathResource("com/douzone/container/config/user/applicationContext01.xml"));
		
		User1 user1 = bf.getBean(User1.class);
		System.out.println(user1.getName());
		
		// Bean Id가 자동으로 설정된다.
		user1 = (User1)bf.getBean("user1");
		System.out.println(user1.getName());
	}
	
	// XML Bean Confinguration(Explicit Configuration)
		private static void testBeanFactory02() {
			BeanFactory bf = new XmlBeanFactory(new ClassPathResource("com/douzone/container/config/user/applicationContext02.xml"));
			
			User1 user1 = bf.getBean(User1.class);
			System.out.println(user1.getName());
			
			// Bean Id가 자동으로 설정되지 않는다.
			// 명시적으로 설정을 해줘야 한다.
			user1 = (User1)bf.getBean("user1");
			System.out.println(user1.getName());
		}
		
}
