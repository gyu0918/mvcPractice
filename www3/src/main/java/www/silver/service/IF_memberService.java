package www.silver.service;

import www.silver.VO.MemberVO;

public interface IF_memberService {
	
	//addUser�� ȸ������ �����Ͻ��� ó���ϱ� ���� ���ǵ� �Լ� 
	//�Ű������� MemberVO, memberVO �� ���� ��Ʈ�ѷ��� ȸ���� ������ �Ѱ��ً� �̸� �ޱ� ���� ��
	//����Ÿ���� void�� ���� �����ͺ��̽� �۾� ����� �����ѷ����� ������ �ʿ䰡 ���� �����̴�.
	public void addUser(MemberVO membervo);
	
	public MemberVO viewUser(String id);
	

}
