package com.example.demo;
import javax.annotation.PostConstruct;
import org.apache.catalina.Container;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatWebServer;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.valves.ErrorReportValve;
import org.springframework.boot.web.servlet.context.AnnotationConfigServletWebServerApplicationContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.apache.catalina.Host;
import org.apache.catalina.Pipeline;
import org.apache.catalina.Valve;
import org.apache.catalina.core.StandardContext;
@SpringBootApplication
public class DemoApplication {
	
	

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		AnnotationConfigServletWebServerApplicationContext webContext=(AnnotationConfigServletWebServerApplicationContext) ApplicationContextHandler.getContext();

		Tomcat tomcat=((TomcatWebServer) webContext.getWebServer()).getTomcat();
		Host host = tomcat.getHost();
		for (Container child : host.findChildren()) {
			if (child instanceof StandardContext) {
				Pipeline pipeline = child.getParent().getPipeline();
					for (Valve valve : pipeline.getValves()) {
						if (valve instanceof ErrorReportValve) {
							pipeline.removeValve(valve);
							break;
						}
					}
				ErrorReportValve valve = new ErrorReportValve();
				valve.setShowServerInfo(false);
				valve.setShowReport(false);
				String currentDir = System.getProperty("user.dir");
				valve.setProperty("errorCode.404",currentDir+"/src/main/resources/templates/redirect.html");
				valve.setProperty("errorCode.0",currentDir+"/src/main/resources/templates/redirect.html");
				pipeline.addValve(valve);
				break;
			}
		}
		System.out.println("MeanWhile start up");
		
	}
	
	
	@PostConstruct
	public static void runBeforeStart() {
		System.out.println("Before start up");
	}

}
