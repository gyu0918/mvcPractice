//package www.silver.hom;
//
//
//
//import java.util.*;
//
//import javax.servlet.http.HttpServletRequest;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//@Controller
//public class HomeController {
//	
//	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
//	
//	/**
//	 * Simply selects the home view to render by returning its name.
//	 */
//	
//	
//	static String[] day = { "월요일", "화요일","수요일","목요일","금요일" };
//	static HashMap<String, String[]> map = new HashMap<String,String[]>();
//	static String[] temp1 = {"a1","a2","a3","쌀밥","떡국","닭볶음탕"};
//	static String[] temp2 = {"b1","b2","b3","잡곡밥","오징어국","불고기"};
//	static String[] temp3 = {"c1","c2","c3","현미밥","김치국","만두"};
//	static String[] temp4 = {"d1","d2","d3","쌀밥","육개장","돈가스"};
//	static String[] temp5 = {"f1","f2","f3","쌀밥","된장국","돼지두루치기"};
//	static List<String> tempList = new ArrayList<String>();
//	
//	@RequestMapping(value = "/", method = RequestMethod.GET)
//	public String home(Locale locale, Model model) {
//		logger.info("Welcome home! The client locale is {}.", locale);
//		
//		
//		return "home";
//	}
//	
////	@ResponseBody
//	@RequestMapping(value = "register", method = RequestMethod.POST)
//	public String reg( HttpServletRequest request) {
//
//		//초기설정
//		
//		map.put(day[0],temp1);
//		map.put(day[1],temp2);
//		map.put(day[2],temp3);
//		map.put(day[3],temp4);
//		map.put(day[4],temp5);
//		
//	
//		//값 찾아와서 넣기 
//		String str = request.getParameter("day");
//	
//		for (int i = 0; i < day.length; i++) {
//			if (day[i].equals(str)) {
//				request.setAttribute(map.get(day[i])[0],map.get(day[i])[3]);
//				request.setAttribute(map.get(day[i])[1],map.get(day[i])[4]);
//				request.setAttribute(map.get(day[i])[2],map.get(day[i])[5]);
//			}
//		}
//		
//		
////		
//		Temp temp = new Temp();
////		
//		request.setAttribute("temp", temp);
////		
////		
//		return "home";
//	}
//	
//	@RequestMapping(value = "Lotto", method = RequestMethod.POST)
//	public String lotto(HttpServletRequest request) {
//		
//		List<Integer> lottoNum = new ArrayList<Integer>();
//		Random random = new Random();
//		String[] temp = {"Lo1","Lo2","Lo3","Lo4","Lo5","Lo6"};
//		
//		for (int i = 0; i < 6; i++) {
//			int num = random.nextInt(45) + 1;
//			if (!lottoNum.contains(num)) {
//				lottoNum.add(num);
//				request.setAttribute(temp[i], num);
//			}else {
//				i--;
//			}
//			
//		}
////		System.out.println(lottoNum);
//		
//		
//		return "home";
//	}
//	
//	@RequestMapping(value = "word", method = RequestMethod.POST)
//	public String word(HttpServletRequest request) {
//		String[] wordName = {"1","2","3","4","5","호호","누구세요","난데요","감자", "고구마"};
//		String[] wordMeaning = {"나는야","누구인가","aa","bb","dd","xxx","qqq","ee","ee","ll"};
//		
//		HashMap<String,String> map = new HashMap<String,String>();
//		
//		//입력
//		for (int i = 0; i <wordName.length; i++) {
//			map.put(wordName[i], wordMeaning[i]);
//		}
//		
//		
//		String word = request.getParameter("wordtext");
//		
//		request.setAttribute("result", map.get(word));
//		
//		return "home";
//	}
//	
//	//--------------------------------------------------------------------------------------
//	
//	static String[][] tdata = {{"서울","대전","부산","천안","대구"},
//			{"새마을","무궁화","새마을","무궁화","새마을"},
//			{"0910","0850","1000","1200","0945"},
//			{"1010","1012","1520","1350","1300"}};
//
//	static String[] temp = {"a1","a2","a3","a4","a5","b1","b2","b3","b4","b5","c1","c2","c3","c4","c5"};
//	static List<String> tlist = new ArrayList<String>();
//
//	
//	@RequestMapping(value = "alltrain", method = RequestMethod.POST)
//	public String alltrain( HttpServletRequest request) {
//	
//	//초기설정
//		int a = 1;
//		int b = 0;
//		for (int i = 0; i < temp.length; i++) {
//			request.setAttribute(temp[i], tdata[a][b]);
//			if (b == 4) {
//				b = 0;
//				a++;
//			}else {
//				b++;
//			}
//	
//		}
//	
//		return "home";
//	}
//	
//	static HashMap<String, String[]> trainMap = new HashMap<String,String[]>();
//	static String[] trainInfo1 = {"새마을","0910","1010","a1","b1","c1"};
//	static String[] trainInfo2 = {"무궁화","0850","1012","a2","b2","c2"};
//	static String[] trainInfo3 = {"새마을","1000","1520","a3","b3","c3"};
//	static String[] trainInfo4 = {"무궁화","1200","1350","a4","b4","c4"};
//	static String[] trainInfo5 = {"새마을","0945","1300","a5","b5","c5"};
//	
//	@RequestMapping(value = "trainword", method = RequestMethod.POST)
//	public String search( HttpServletRequest request) {
//	
//		//초기설정
//		trainMap.put(tdata[0][0], trainInfo1);
//		trainMap.put(tdata[0][1], trainInfo2);
//		trainMap.put(tdata[0][2], trainInfo3);
//		trainMap.put(tdata[0][3], trainInfo4);
//		trainMap.put(tdata[0][4], trainInfo5);
//		for (int i = 0; i < tdata[0].length; i++) {
//			tlist.add(tdata[0][i]);
//		}
//		
//		String word = request.getParameter("wordtext");
//		
////		System.out.println(word);
//		
//		if (tlist.contains(word)) {
//			for (int i = 0; i < trainMap.get(word).length - 3; i++) {
//				request.setAttribute(trainMap.get(word)[i + 3], trainMap.get(word)[i]);
//			}
//		}
//		
//		
//		return "home";
//	}
//	
//
//	static List<String> tlist2 = new ArrayList<String>();
//	@RequestMapping(value = "search", method = RequestMethod.POST)
//	public String checkBox( HttpServletRequest request) {
//	
//		//초기설정
//		trainMap.put(tdata[0][0], trainInfo1);
//		trainMap.put(tdata[0][1], trainInfo2);
//		trainMap.put(tdata[0][2], trainInfo3);
//		trainMap.put(tdata[0][3], trainInfo4);
//		trainMap.put(tdata[0][4], trainInfo5);
//		for (int i = 0; i < tdata[0].length; i++) {
//			tlist2.add(tdata[0][i]);
//		}
//		
//		
//		//내가 한부분---------------------------------------------------------------
////		String[] index = {"1","2","3","4","5"};
////		List<String> checkList = new ArrayList<String>();
////		
////		for (int i = 0; i < index.length; i++) {
////			checkList.add(request.getParameter(index[i]));
////		}
//		
////		System.out.println(checkList);
//////		System.out.println(checkList.isEmpty());
////		
////		if (!checkList.isEmpty()) {
////			for (int i = 0; i < checkList.size() ; i++) {
////				if (checkList.get(i) != null) {
////					for (int j = 0; j < 3; j++) {
////						request.setAttribute(trainMap.get(checkList.get(i))[j + 3], trainMap.get(checkList.get(i))[j]);
////					}
////				}
////			}
////				
////		}
//		
//		//티쳐의 손길
//		String[] ab = request.getParameterValues("1");
//	
//		if (ab != null) {
//			for (int i = 0; i < ab.length; i++) {
//				for (int j = 0; j < 3; j++) {
//					request.setAttribute(trainMap.get(ab[i])[j + 3], trainMap.get(ab[i])[j]);
//				}
//			}
//		}
//		
//		return "home";
//	}
//	
//	
//	
//	
//	
//	
//}
//
