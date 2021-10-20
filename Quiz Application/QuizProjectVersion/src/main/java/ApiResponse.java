
public class ApiResponse {
	String statusCode;
	String content;
	String status;
	
	public ApiResponse()
	{
		super();
	}
	
	public ApiResponse(String statusCode, String content, String status) {
		super();
		this.statusCode = statusCode;
		this.content = content;
		this.status = status;
	}
	
	public String getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
