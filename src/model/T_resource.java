package model;

public class T_resource {
	public T_resource() {
		super();
		// TODO Auto-generated constructor stub
	}
	private int resourceId;
	private String resourceName;
	private String url;
	public int getResourceId() {
		return resourceId;
	}
	public void setResourceId(int resourceId) {
		this.resourceId = resourceId;
	}
	public String getResourceName() {
		return resourceName;
	}
	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}
	@Override
	public String toString() {
		return "resource [resourceId=" + resourceId + ", resourceName=" + resourceName + ", url=" + url + "]";
	}
	public T_resource(int resourceId, String resourceName, String url) {
		super();
		this.resourceId = resourceId;
		this.resourceName = resourceName;
		this.url = url;
	}

	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}

}
