package designmode.filter.web;

public class WebFilterImpl3 implements WebFilter {

	@Override
	public void doFilter(Request request,Response response,WebFilterChain chain) {
		request.requestStr+="--WebFilterImpl3 ";
		chain.doFilter(request, response, chain);
		response.responseStr+="--WebFilterImpl3 ";
	}

}
