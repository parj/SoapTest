/**
 * Created with IntelliJ IDEA.
 * User: parj
 * Date: 04/05/2013
 * Time: 17:53
 * To change this template use File | Settings | File Templates.
 */

package org.pm.simple;
import javax.annotation.Resource;
import javax.jws.WebService;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;
import java.util.*;

@WebService(serviceName="HelloWorld")
public class MyServiceImpl implements MyService {
    @Resource
    WebServiceContext ctxt;

    public String hello() {
        // Retrieve the MessageContext from the injected WebServiceContext.
        MessageContext mc = ctxt.getMessageContext();

        // Send some headers back in the response message.
        Map<String, Object> responseHeaders = new HashMap<String, Object>();
        responseHeaders.put("Access-Control-Allow-Origin", Collections.singletonList("*"));
        responseHeaders.put("Access-Control-Allow-Methods", Arrays.asList("GET", "OPTIONS", "POST"));
        responseHeaders.put("Access-Control-Allow-Headers", Arrays.asList("Content-Type", "Authorization", "Accept"))  ;

        // Set the response header Map on the MessageContext.
        mc.put(MessageContext.HTTP_RESPONSE_HEADERS, responseHeaders);
        
        return "Hello World!";
    }

    /*public String sayHi(String text) {
        return "Hi " + text;
    }*/
}