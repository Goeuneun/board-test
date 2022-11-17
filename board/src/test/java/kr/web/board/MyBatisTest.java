package kr.web.board;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.internal.runners.JUnit4ClassRunner;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;

@RunWith(JUnit4ClassRunner.class)
@ContextConfiguration ( locations = "file:src/main/webapp/WEB-INF/spring/*.xml" )
public class MyBatisTest {
	
	@Inject
	private SqlSessionFactory sqlFactory;

	@Test
	public void testFactory() {
		System.out.println(sqlFactory);
	}

	@Test
	public void testSession() throws Exception {
		try (SqlSession session = sqlFactory.openSession()) {
			System.out.println(session);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
