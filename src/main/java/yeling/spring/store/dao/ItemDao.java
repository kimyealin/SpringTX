package yeling.spring.store.dao;

import yeling.spring.store.vo.Item;

//������ �˻����� �������̽�
public interface ItemDao {
	Item findById(Integer itemId);
}
