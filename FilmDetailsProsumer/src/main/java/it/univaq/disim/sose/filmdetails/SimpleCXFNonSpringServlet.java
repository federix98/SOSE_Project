package it.univaq.disim.sose.filmdetails;

import javax.servlet.ServletConfig;
import javax.xml.ws.Endpoint;
import org.apache.cxf.Bus;
import org.apache.cxf.BusFactory;
import org.apache.cxf.transport.servlet.CXFNonSpringServlet;

public class SimpleCXFNonSpringServlet extends CXFNonSpringServlet {

	private static final long serialVersionUID = -4978737275160241311L;

	@Override
	public void loadBus(ServletConfig servletConfig) {
		super.loadBus(servletConfig);
		
		Bus bus = getBus();
		BusFactory.setDefaultBus(bus);
		Endpoint.publish("/filmdetails", new FilmDetailsImpl());
	}
	
}
