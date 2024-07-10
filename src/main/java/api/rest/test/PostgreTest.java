package api.rest.test;

import java.util.List;
import java.util.Map;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@Repository
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:C:\\2024thFirstHalf_2\\Java\\STSworkspace\\OpenBankAPIServer\\src\\main\\webapp\\WEB-INF\\spring\\**\\*.xml"})
public class PostgreTest {
	
	@Autowired
	private SqlSessionTemplate session;
	
//	@Ignore
	@Test
	public void 연결테스트(){
		try {
		List<Map<String,Object>> a =  session.selectList("postgre.PIIDAO.test");
		for(Map<String,Object> s:a) {
			for (Map.Entry<String, Object> e : s.entrySet()) {
                String key = e.getKey();
                Object value = e.getValue();
                System.out.println(key + " : " + value);
            }
			System.out.println();
		}
		}catch(Exception e) {
			System.out.println("7월 10일까지는 됐었음.");
			e.printStackTrace();
		}
		
	}
	
	@Ignore
	@Test
	public void create() {
		session.update("postgre.PIIDAO.createPII");
		System.out.println("완료");
	}
	
}






