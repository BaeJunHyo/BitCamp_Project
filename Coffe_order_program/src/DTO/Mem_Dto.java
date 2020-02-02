package DTO;
/* [DB TABLE]
ID VARCHAR2(30) PRIMARY KEY,
PWD VARCHAR2(30) NOT NULL,
NAME VARCHAR2(50) NOT NULL,
AGE VARCHAR2(10) NOT NULL,
AUTH NUMBER(1) NOT NULL
*/

public class Mem_Dto {
	private String id;
	private String pwd;
	private String name;
	private String age;
	private int auth;
	
	// 기본생성자
	public Mem_Dto() {
	}
	public Mem_Dto(String id, String pwd, String name, String age, int auth) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.age = age;
		this.auth = auth;
	}
	
	// getter/setter
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public int getAuth() {
		return auth;
	}
	public void setAuth(int auth) {
		this.auth = auth;
	}
	@Override
	public String toString() {
		return "Mem_Dto [id=" + id + ", pwd=" + pwd + ", name=" + name + ", age=" + age + ", auth=" + auth + "]";
	}
	
	
	

	
	
	
	
	
}
