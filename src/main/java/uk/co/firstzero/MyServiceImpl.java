/**
 * Created with IntelliJ IDEA.
 * User: parj
 * Date: 04/05/2013
 * Time: 17:53
 * To change this template use File | Settings | File Templates.
 */

package uk.co.firstzero;
import org.apache.cxf.rs.security.cors.CrossOriginResourceSharing;

import javax.annotation.Resource;
import javax.jws.WebService;
import javax.ws.rs.OPTIONS;
import javax.ws.rs.core.Response;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;
import java.util.*;



@WebService(serviceName="HelloWorld")
@CrossOriginResourceSharing(
        allowAllOrigins = true,
        allowHeaders = {
                "Accept", "Accept-Language", "Access-Control-Request-Headers", "Access-Control-Request-Method", "connection", "Content-Type", "Host",  "Origin", "Referer", "Authorization", "cache-control", "control-type", "soapaction", "Http-Method"
        },
        exposeHeaders = {
                "Accept", "Accept-Language", "Access-Control-Request-Headers", "Access-Control-Request-Method", "connection", "Content-Type", "Host",  "Origin", "Referer", "Authorization", "cache-control", "control-type", "soapaction", "Http-Method"
        }
)
public class MyServiceImpl implements MyService {
    @Resource
    WebServiceContext ctxt;

    //TODO - PRE-FLIGHT Response - Not yet working
    @OPTIONS
    public Response returnResponse() {
        return Response.ok()
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Methods", "POST, GET, UPDATE, OPTIONS")
                .header("Access-Control-Allow-Headers", "x-http-method-override").build();
    }

    public String hello() {
        // Retrieve the MessageContext from the injected WebServiceContext.
        MessageContext mc = ctxt.getMessageContext();

        // Send some headers back in the response message.
        Map<String, Object> responseHeaders = new HashMap<String, Object>();
        responseHeaders.put("Access-Control-Allow-Origin", Arrays.asList("'*'"));
        responseHeaders.put("Access-Control-Allow-Methods", Arrays.asList("GET", "OPTIONS", "POST", "HEAD", "PUT", "CONNECT"));
        responseHeaders.put("Access-Control-Allow-Headers", Arrays.asList("Accept", "Accept-Language", "Access-Control-Request-Headers", "Access-Control-Request-Method", "connection", "Content-Type", "Host",  "Origin", "Referer", "Authorization", "cache-control", "control-type", "soapaction", "Http-Method"))  ;

        // Set the response header Map on the MessageContext.
        mc.put(MessageContext.HTTP_RESPONSE_HEADERS, responseHeaders);

        return "Hello World!";
    }

    public String sayHi(String text) {
        return "Hi " + text;
    }

    /*@GET
    @Produces(MediaType.TEXT_HTML)
    public String html() {
        return "<html> " + "<title>" + "Rest Page" + "</title>"
                + "<body><h1>" + "REST is Working!" + "</body></h1>" + "</html> ";
    }*/
}