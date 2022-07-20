package yeling.spring.store.dao.jdbc;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import yeling.spring.store.dao.PaymentInfoDao;
import yeling.spring.store.vo.PaymentInfo;

//PaymentInfoDao 인터페이스 구현한 클래스
public class JdbcPaymentInfoDao implements PaymentInfoDao {
	private SimpleJdbcInsert insert;
	private NamedParameterJdbcTemplate namedJdbcTemplate;
	

	public JdbcPaymentInfoDao(SimpleJdbcInsert insert) {
		this.insert = insert;
		insert.withTableName("payment_info").usingColumns("payment_info_id", "price");
	}
	public void setNamedJdbcTemplate(NamedParameterJdbcTemplate namedJdbcTemplate) {
		this.namedJdbcTemplate = namedJdbcTemplate;
	}
	public int nextVal() {
		return namedJdbcTemplate.queryForObject("select payment_seq.nextval from dual", Collections.emptyMap(), Integer.class);
	}

	@Override
	public void insert(PaymentInfo paymentInfo) {
		Map<String, Object> paramValueMap = new HashMap<String, Object>();
		paymentInfo.setId(nextVal());
		paramValueMap.put("payment_info_id", paymentInfo.getId());
		paramValueMap.put("price", paymentInfo.getPrice());
		insert.execute(paramValueMap);
	}
}
