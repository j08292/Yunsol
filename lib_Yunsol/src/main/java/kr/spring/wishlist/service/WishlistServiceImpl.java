package kr.spring.wishlist.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.spring.wishlist.dao.WishlistMapper;
import kr.spring.wishlist.domain.WishlistCommand;

@Service("wishlistService")
public class WishlistServiceImpl implements WishlistService{

	@Resource
	private WishlistMapper wishlistMapper;
		
	@Override
	public List<WishlistCommand> list(Map<String, Object> map) {
		return wishlistMapper.list(map);
	}

	@Override
	public int getRowCount(Map<String, Object> map) {
		return wishlistMapper.getRowCount(map);
	}

	@Override
	public void insert(WishlistCommand wishlist) {
		wishlistMapper.insert(wishlist);
	}

	@Override
	public WishlistCommand selectWishlist(Integer wish_num) {
		return wishlistMapper.selectWishlist(wish_num);
	}
	
	@Override
	public void updateStatusChange(WishlistCommand wishlist) {
		wishlistMapper.updateStatusChange(wishlist);
	}
}