//package www.silver.hom;
//
//import javax.servlet.http.HttpServletRequest;
//
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//
//public class controller {
//	
//	private ObjectMapper objectMapper = new ObjectMapper();
//	
//	@RequestMapping(value = "/request-body-json", method = RequestMethod.POST)
//	public String ResponseJsonServlet(HttpServletRequest request  ) {
//		try{
//			request.setCharacterEncoding("UTF-8");
//			
//		}catch(Exception e) {
//			
//		}
//		
//		
//		Temp temp = new Temp();
//		
//		request.setAttribute("temp", temp);
//		
//		
//		
//
//}
