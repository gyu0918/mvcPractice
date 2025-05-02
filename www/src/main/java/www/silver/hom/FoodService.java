package www.silver.hom;

import java.util.*;

public class FoodService {
	

	static List<String[]> foodList = new ArrayList<String[]>() {{
        add(new String[] {"«��", "7000", "������", "����"});
        add(new String[] {"¥���", "6000", "�����", "�߱�"});
        add(new String[] {"������", "20000", "û�۱�", "ĳ����"});
        add(new String[] {"������", "30000", "ĳ����", "�Ϻ�"});
    }};
    
    static List<String> nameList = new ArrayList<String>() {{
    	add("«��");
    	add("¥���");
    	add("������");
    	add("������");
    }};
    
    
    public List<FoodDTO> searchFood(String foodName){
		
		List<FoodDTO> list2 = new ArrayList<FoodDTO>();
		
		FoodDTO fdto = null;
		
		if (nameList.contains(foodName)) {
			int index  = nameList.indexOf(foodName);
			fdto = new FoodDTO();
			fdto.setName(foodList.get(index)[0]);
			fdto.setPrice(foodList.get(index)[1]);
			fdto.setLocation(foodList.get(index)[2]);
			fdto.setContry(foodList.get(index)[3]);
			list2.add(fdto);
		}
		
		return list2;
	}
    
    
	public List<FoodDTO> ReadAll(){
		
		List<FoodDTO> list = new ArrayList<FoodDTO>();
		
		FoodDTO fdto = null;
		
		for (int i = 0; i < foodList.size(); i++) {
			fdto = new FoodDTO();
			fdto.setName(foodList.get(i)[0]);
			fdto.setPrice(foodList.get(i)[1]);
			fdto.setLocation(foodList.get(i)[2]);
			fdto.setContry(foodList.get(i)[3]);
			list.add(fdto);
		}
		
		
		
		return list;
	}
	
	public void createFood(String[] test) {
		
		foodList.add(new String[] {test[0],test[1],test[2],test[3]});
		nameList.add(test[0]);

	}
	
	public void deleteFood(String menuName) {
		
		if (nameList.contains(menuName)) {
			int index = nameList.indexOf(menuName);
			foodList.remove(index);
			nameList.remove(index);
		}
	}
	
	public void updateFood(String[] update) {
		
		int index = nameList.indexOf(update[0]);
		String[] updateFood = {update[0],update[1],update[2],update[3]};

		foodList.set(index,updateFood);

	}

}
