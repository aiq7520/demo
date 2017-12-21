package designmode.filter.web;

public class WebFilterImpl1 implements WebFilter {

	@Override
	public void doFilter(Request request,Response response,WebFilterChain chain) {
		request.requestStr+="--WebFilterImpl1 ";
		chain.doFilter(request, response, chain);
		response.responseStr+="--WebFilterImpl1 ";
	}

}
