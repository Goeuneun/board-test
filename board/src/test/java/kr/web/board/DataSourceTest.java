package kr.web.board;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.junit.Test;
import org.junit.internal.runners.JUnit4ClassRunner;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;

// ���� �׽�Ʈ �ڵ带 �����Ҷ� �������� �ε��ǵ����ϴ� �κ�
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
