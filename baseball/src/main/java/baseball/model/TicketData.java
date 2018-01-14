package baseball.model;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.type.Alias;
import org.springframework.stereotype.Component;

@Component
public class TicketData {

	/**
	 * @uml.property  name="service"
	 */
	String service;

	/**
	 * @uml.property  name="path"
	 */
	String path;
	
	/**
	 * @uml.property  name="dd"
	 */
	Object dd;
	
	
	/**
	 * @uml.property  name="redirect"
	 */
	boolean redirect;
	
	/**
	 * @uml.property  name="request"
	 * @uml.associationEnd  
	 */
	HttpServletRequest request;
	

	/**
	 * @return
	 * @uml.property  name="request"
	 */
	public HttpServletRequest getRequest() {
		return request;
	}

	/**
	 * @param request
	 * @uml.property  name="request"
	 */
	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	/**
	 * @return
	 * @uml.property  name="path"
	 */
	public String getPath() {
		return path;
	}

	/**
	 * @param path
	 * @uml.property  name="path"
	 */
	public void setPath(String path) {
		this.path = path;
	}

	/**
	 * @return
	 * @uml.property  name="redirect"
	 */
	public boolean isRedirect() {
		return redirect;
	}

	/**
	 * @param redirect
	 * @uml.property  name="redirect"
	 */
	public void setRedirect(boolean redirect) {
		this.redirect = redirect;
	}

	

	/**
	 * @return
	 * @uml.property  name="dd"
	 */
	public Object getDd() {
		return dd;
	}

	/**
	 * @param dd
	 * @uml.property  name="dd"
	 */
	public void setDd(Object dd) {
		this.dd = dd;
	}

	

	/**
	 * @return
	 * @uml.property  name="service"
	 */
	public String getService() {
		return service;
	}

	/**
	 * @param service
	 * @uml.property  name="service"
	 */
	public void setService(String service) {
		this.service = service;
	}

	@Override
	public String toString() {
		return "TicketData service=" + service + ", path=" + path + ", dd=" + dd + ", redirect="
				+ redirect + ", request=" + request + "]";
	}
	
	
}
