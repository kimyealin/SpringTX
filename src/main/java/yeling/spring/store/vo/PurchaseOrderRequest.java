package yeling.spring.store.vo;

//구매 주문 요구사항을 나타내는 클래스
public class PurchaseOrderRequest {
	private Integer itemId;
	private String address;
	
	public Integer getItemId() {
		return itemId;
	}
	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
}
