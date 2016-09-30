package kr.spring.wishlist.service;

import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import kr.spring.wishlist.domain.WishlistCommand;

@Transactional
public interface WishlistService {
	@Transactional(readOnly=true)
	public List<WishlistCommand> list(Map<String, Object> map);
	@Transactional(readOnly=true)
	public int getRowCount(Map<String, Object> map);
	public void insert(WishlistCommand wishlist);
	@Transactional(readOnly=true)
	public WishlistCommand selectWishlist(Integer wish_num);
	public void updateStatusChange(WishlistCommand wishlist);	
}