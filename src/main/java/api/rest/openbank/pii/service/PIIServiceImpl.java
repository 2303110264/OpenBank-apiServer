package api.rest.openbank.pii.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import api.rest.openbank.pii.dao.PIIDAO;
import api.rest.openbank.pii.vo.PIIVO;

@Service
public class PIIServiceImpl implements PIIService {
	
	@Autowired
	PIIDAO pDao;
	
	@Override
//	public int insertPII(HashMap<String, Object> pii) {
	public int insertPII(PIIVO pii) {
		return pDao.insertPII(pii);
	}
}
