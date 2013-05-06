/**
 * Created with IntelliJ IDEA.
 * User: parj
 * Date: 04/05/2013
 * Time: 17:52
 * To change this template use File | Settings | File Templates.
 */

package uk.co.firstzero;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public interface MyService {
    public String hello();

    public String sayHi(@WebParam(name="text") String text);
}
