package kr.web.board;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.junit.Test;
import org.junit.internal.runners.JUnit4ClassRunner;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;

// 현재 테스트 코드를 실행할때 스프링이 로딩되도록하는 부분
@RunWith(JUnit4ClassRunner.class)
@ContextConfiguration( "file:src/main/webapp/WEB-INF/spring/*.xml"  )
public class DataSourceTest {
	@Inject
	private DataSource ds;

	@Test
	public void testConnection() throws Exception {
		try (Connection con = ds.getConnection()) {
			System.out.println(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

}
