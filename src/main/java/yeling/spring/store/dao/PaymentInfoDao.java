package yeling.spring.store.dao;

import yeling.spring.store.vo.PaymentInfo;

//결제정보 저장해줄 인터페이스
public interface PaymentInfoDao {
	void insert(PaymentInfo paymentInfo);
}
