package yeling.spring.store.dao;

import yeling.spring.store.vo.PurchaseOrder;

//구매주문 결과 저장해줄 인터페이스
public interface PurchaseOrderDao {
	void insert(PurchaseOrder order);
}
