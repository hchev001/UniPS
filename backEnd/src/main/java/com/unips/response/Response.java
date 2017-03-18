package com.unips.response;

public class Response <AnyData> {
	
	private static final String SUCCESS = "success";
	private static final String FAILURE = "failure";
	
	private String status;
	private AnyData data;
	private String error;
	

	private Response(String status, AnyData data, String error) {
		this.status = status;
		this.data = data;
		this.error = error;;
	}
	
	
	private Response(String status, AnyData data) {
		this(status, data,"");
	}
	
	private Response(String status, String error) {
		this(status, null, error);
	}
	
	public static <AnyData> Response<AnyData> success(AnyData data) {
		return new Response<AnyData>(SUCCESS, data);
	}
	
	public static <AnyData> Response<AnyData> failure(String error) {
		return new Response<AnyData>(FAILURE, error);
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public AnyData getData() {
		return data;
	}

	public void setData(AnyData data) {
		this.data = data;
	}


	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}	
}
