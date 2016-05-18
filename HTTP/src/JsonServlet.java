import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;



public class JsonServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public JsonServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		//设置服务器响应头的数据的编码方式（有中文时，一定不要忘了设置）
		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		Result result = new Result();
		result.setResult(1);
		List<Person> persons = new ArrayList<Person>();
		Person person = new Person();
		person.setName("张三");
		person.setAge(19);
		person.setUrl("http://img0.imgtn.bdimg.com/it/u=2881239247,2250758631&fm=11&gp=0.jpg");
		List<SchoolInfo> schoolInfos = new ArrayList<SchoolInfo>();
		SchoolInfo schoolInfo1 = new SchoolInfo();
		schoolInfo1.setName("清华");
		schoolInfos.add(schoolInfo1);
		SchoolInfo schoolInfo2 = new SchoolInfo();
		schoolInfo2.setName("北大");
		schoolInfos.add(schoolInfo2);
		person.setSchoolInfos(schoolInfos);
		persons.add(person);
		Person person1 = new Person();
		person1.setName("李四");
		person1.setAge(20);
		person1.setUrl("http://img5.duitang.com/uploads/item/201509/11/20150911212955_Mae8u.jpeg");
		List<SchoolInfo> schoolInfos1 = new ArrayList<SchoolInfo>();
		SchoolInfo schoolInfo11 = new SchoolInfo();
		schoolInfo11.setName("清华");
		schoolInfos1.add(schoolInfo11);
		SchoolInfo schoolInfo21 = new SchoolInfo();
		schoolInfo21.setName("北大");
		schoolInfos1.add(schoolInfo21);
		person1.setSchoolInfos(schoolInfos1);
		persons.add(person1);
		result.setPerson(persons);
		
		Gson gson = new Gson();
		
		out.println(gson.toJson(result));
		
		System.out.println(gson.toJson(result));
		
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
