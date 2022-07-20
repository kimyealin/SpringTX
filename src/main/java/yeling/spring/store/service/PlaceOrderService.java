package yeling.spring.store.service;

import yeling.spring.store.vo.ItemNotFoundException;
import yeling.spring.store.vo.PurchaseOrderRequest;
import yeling.spring.store.vo.PurchaseOrderResult;

//���ż��� �߻�ȭ�� �������̽�
public interface PlaceOrderService {
	public PurchaseOrderResult order(PurchaseOrderRequest orderRequest) throws ItemNotFoundException;
}
