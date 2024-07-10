package api.rest.openbank.pii.service;

import java.util.HashMap;

import api.rest.openbank.pii.vo.PIIVO;

public interface PIIService {
	//개인식별정보 추가 (map => name, phone, agree(개인정보 제3자제공동의여부) = 'Y' or 'N')
//	public int insertPII(HashMap<String,Object> map);
	public int insertPII(PIIVO pii);
}
