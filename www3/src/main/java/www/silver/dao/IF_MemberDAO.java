package www.silver.dao;

import www.silver.VO.MemberVO;

public interface IF_MemberDAO {
	
	//������ ���񽺴ܿ� �ϰ� , sqlsessiontemplate�� ȣ���Ѵ�.
	// �ָ����� �������� �����ϱ� ���� ��  �����Ͻ� ó������ �����ؾ� �Ѵ�.
	public void insertMember(MemberVO mvo);

}
