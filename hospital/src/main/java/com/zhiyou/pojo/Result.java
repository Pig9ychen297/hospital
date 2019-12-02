package com.zhiyou.pojo;

public class Result {
	private int code;
	private boolean flag;
	private String message;
	private Object object;
	
	
	
	
	public static Result success(int code,String message,Object object){
		Result result = new Result();
		result.setCode(code);
		result.setMessage(message);
		result.setFlag(true);
		result.setObject(object);
		return result;
	}
	
	public static Result success(int code,String message){
		Result result = new Result();
		result.setCode(code);
		result.setMessage(message);
		result.setFlag(true);
		return result;
	}
	
	public static Result fail(int code,String message){
		Result result = new Result();
		result.setCode(code);
		result.setMessage(message);
		result.setFlag(false);
		return result;
	}
	
	public static Result fail(int code,String message,Object object){
		Result result = new Result();
		result.setCode(code);
		result.setMessage(message);
		result.setFlag(false);
		result.setObject(object);
		return result;
	}
	
	public Object getObject() {
		return object;
	}
	public void setObject(Object object) {
		this.object = object;
	}

	private User user;
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	
	
	public boolean isFlag() {
		return flag;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Result() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Result(int code, boolean flag, String message) {
		super();
		this.code = code;
		this.flag = flag;
		this.message = message;
	}
	
	@Override
	public String toString() {
		return "Result [code=" + code + ", flag=" + flag + ", message=" + message + "]";
	}
	

	
	
	
}
