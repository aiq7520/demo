package ssm.webservice;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

@WebService
@SOAPBinding(style = Style.RPC)
public interface CordovaWebService {//webService½Ó¿Ú
	@WebMethod
	public String cordovaAndiroLogin(@WebParam(name="name")String name,@WebParam(name="pwd")String pwd) throws Exception ;
}
