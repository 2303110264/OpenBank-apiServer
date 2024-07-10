package api.rest.openbank.pii.dao;

import api.rest.openbank.pii.vo.PIIVO;

public interface PIIDAO {
	//개인식별정보 추가 (map => name, phone, agree(개인정보 제3자제공동의여부) = 'Y' or 'N')
//	public int insertPII(HashMap<String,Object> pii);
	public int insertPII(PIIVO pii);
}