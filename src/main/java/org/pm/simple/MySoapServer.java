/**
 * Created with IntelliJ IDEA.
 * User: parj
 * Date: 04/05/2013
 * Time: 17:50
 * To change this template use File | Settings | File Templates.
 */
package org.pm.simple;
import javax.xml.ws.Endpoint;


public class MySoapServer {
    public static void main(String[] args) {
        String serviceAddress = "http://localhost:9099/mysoap";
        MyService implementor = new MyServiceImpl();
        Endpoint ep = Endpoint.publish(serviceAddress, new MyServiceImpl());
    }
}