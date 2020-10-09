package springhtwo.tee;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.rules.TestRule;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TeeApplicationTests {
	@Autowired
	private JdbcTemplate jdbcTemplate;
//	@Rule
//	public ExpectedException thrown = TestRule.apply;
//	@Test(expected = CustomDuplicatedKeyException.class)
	@Test(expected = CustomDuplicatedKeyException.class)
	public void testThrowingCustomException() {
		jdbcTemplate.execute("INSERT INTO FOO (ID,BAR) VALUES (3,'A')");
		jdbcTemplate.execute("INSERT INTO FOO (ID,BAR) VALUES (3,'B')");
	}
}
