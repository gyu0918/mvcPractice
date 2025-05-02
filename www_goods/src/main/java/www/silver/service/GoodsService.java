package www.silver.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import www.silver.VO.InsertVO;
import www.silver.VO.ResponseVO;
import www.silver.repository.GoodsRepository;

@Service
public class GoodsService {
	
	@Inject
	private GoodsRepository goodsRepository;
	
	public void insertGoods(InsertVO insertVO) {
		goodsRepository.insertGoods(insertVO);
	}
	
	public ResponseVO joinGoods(String goodsname) {
		return goodsRepository.joinGoods(goodsname);
	}
}
