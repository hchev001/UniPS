package com.unips.response;

@SuppressWarnings("unused")
public class Response <AnyData> {
	
	private static final String SUCCESS = "success";
	private static final String FAILURE = "failure";

	private String status;
	private AnyData data;
	
	
	private Response(String status, AnyData data) {
		this.status = status;
		this.data = data;
	}

	
	public static <AnyData> Response<AnyData> success(AnyData data) {
		return new Response<AnyData>(SUCCESS, data);
	}
	
	public static <AnyData> Response<AnyData> failure(AnyData data) {
		return new Response<AnyData>(FAILURE, data);
	}	
}
