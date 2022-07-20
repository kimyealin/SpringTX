package yeling.spring.store.service;

import yeling.spring.store.vo.ItemNotFoundException;
import yeling.spring.store.vo.PurchaseOrderRequest;
import yeling.spring.store.vo.PurchaseOrderResult;

//구매서비스 추상화한 인터페이스
public interface PlaceOrderService {
	public PurchaseOrderResult order(PurchaseOrderRequest orderRequest) throws ItemNotFoundException;
}
