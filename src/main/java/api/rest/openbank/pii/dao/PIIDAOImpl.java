package api.rest.openbank.pii.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import api.rest.openbank.pii.vo.PIIVO;

@Repository
public class PIIDAOImpl implements PIIDAO{
	
	@Autowired
	SqlSessionTemplate session;

	@Override
//	public int insertPII(HashMap<String, Object> pii) {
	public int insertPII(PIIVO pii) {
		return session.insert("postgre.insertPII", pii);
	}
}
