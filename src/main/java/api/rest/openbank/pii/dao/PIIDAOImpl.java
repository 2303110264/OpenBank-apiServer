package api.rest.openbank.pii.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import api.rest.openbank.pii.vo.PIIVO;

@Repository
public class PIIDAOImpl implements PIIDAO{
	
	private SqlSessionTemplate session;
	
	@Autowired
    public PIIDAOImpl(@Qualifier("localSessionTemplate") SqlSessionTemplate local
    		, @Qualifier("sqlSessionTemplate") SqlSessionTemplate properties
    		, @Qualifier("koyebSessionTemplate") SqlSessionTemplate systemEnv) {
        System.out.println("Testing...");
		try {
			this.session = local;
			this.session.getConnection();
			System.out.println("OK");
		}catch(Exception e) {
			try {
				this.session = systemEnv;
				this.session.getConnection();
				System.out.println("1 Fail but OK");
				
			}catch(Exception e2) {
				this.session = properties;
				System.out.println("2 Fail maybe OK ... "+this.session.getConnection());;
			}
		}
        
	}
	
	@Override
//	public int insertPII(HashMap<String, Object> pii) {
	public int insertPII(PIIVO pii) {
		return session.insert("postgre.insertPII", pii);
	}
}
