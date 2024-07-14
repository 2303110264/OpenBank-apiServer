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
    		, @Qualifier("sqlSessionTemplate") SqlSessionTemplate properties) {
        System.out.println("Testing...");
		try {
			this.session = local;
			if(this.session.getConnection()!=null)
				System.out.println("OK");
			else System.out.println("not OK...");
		}catch(Exception e) {
			try {
				this.session = properties;
				if(this.session.getConnection()!=null)
					System.out.println("1 Fail but OK");
				
			}catch(Exception e2) {
				System.out.println("umm... I don't know anything...");
			}
		}
        
	}
	
	@Override
//	public int insertPII(HashMap<String, Object> pii) {
	public int insertPII(PIIVO pii) {
		return session.insert("postgre.insertPII", pii);
	}
}
