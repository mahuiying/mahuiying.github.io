

import java.util.List;

public class Person {

	private String name;
	private int age;
	private String url;
	private List<SchoolInfo> schoolInfos;
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public List<SchoolInfo> getSchoolInfos() {
		return schoolInfos;
	}
	public void setSchoolInfos(List<SchoolInfo> schoolInfos) {
		this.schoolInfos = schoolInfos;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
}
