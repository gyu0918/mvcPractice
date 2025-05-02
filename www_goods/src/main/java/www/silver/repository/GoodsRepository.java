package www.silver.repository;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import www.silver.VO.InsertVO;
import www.silver.VO.ResponseVO;

@Repository
public class GoodsRepository {

	
	@Inject
	private  SqlSession sqlsession;
	
	public void insertGoods(InsertVO insertVO) {
		sqlsession.insert("aa.insertGoods", insertVO);
	}
	
	public ResponseVO joinGoods(String goodsname) {
		
		return sqlsession.selectOne("aa.joinGoods", goodsname);
	}
	
	
}
