package kr.spring.book.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import kr.spring.book.domain.DeliveryCommand;

@Transactional
public interface DeliveryService {
	@Transactional(readOnly=true)
	public List<DeliveryCommand> list(String mem_id);
	public void insert(DeliveryCommand delivery);

}
