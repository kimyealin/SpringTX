package yeling.spring.store.dao;

import yeling.spring.store.vo.Item;

//아이템 검색해줄 인터페이스
public interface ItemDao {
	Item findById(Integer itemId);
}
