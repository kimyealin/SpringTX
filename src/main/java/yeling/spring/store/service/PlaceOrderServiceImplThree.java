package yeling.spring.store.service;

import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import yeling.spring.store.dao.ItemDao;
import yeling.spring.store.dao.PaymentInfoDao;
import yeling.spring.store.dao.PurchaseOrderDao;
import yeling.spring.store.vo.Item;
import yeling.spring.store.vo.ItemNotFoundException;
import yeling.spring.store.vo.PaymentInfo;
import yeling.spring.store.vo.PurchaseOrder;
import yeling.spring.store.vo.PurchaseOrderRequest;
import yeling.spring.store.vo.PurchaseOrderResult;

public class PlaceOrderServiceImplThree implements PlaceOrderService {

	private ItemDao itemDao;
	private PaymentInfoDao paymentInfoDao;
	private PurchaseOrderDao purchaseOrderDao;
	
	public void setItemDao(ItemDao itemDao) {
		this.itemDao = itemDao;
	}	
	public void setPaymentInfoDao(PaymentInfoDao paymentInfoDao) {
		this.paymentInfoDao = paymentInfoDao;
	}
	public void setPurchaseOrderDao(PurchaseOrderDao purchaseOrderDao) {
		this.purchaseOrderDao = purchaseOrderDao;
	}
	
	@Override
	@Transactional
	public PurchaseOrderResult order(PurchaseOrderRequest orderRequest) throws ItemNotFoundException {

		Item item = itemDao.findById(orderRequest.getItemId());
		if(item == null) throw new ItemNotFoundException(orderRequest.getItemId());
		PaymentInfo paymentInfo = new PaymentInfo(item.getPrice());
		paymentInfoDao.insert(paymentInfo);
		PurchaseOrder order = new PurchaseOrder(item.getId(), orderRequest.getAddress(), paymentInfo.getId());
		purchaseOrderDao.insert(order);
		return new PurchaseOrderResult(item, paymentInfo, order);
	}

}
