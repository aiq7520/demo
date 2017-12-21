package designmode.filter.web;

public class WebFilterImpl2 implements WebFilter {

	@Override
	public void doFilter(Request request,Response response,WebFilterChain chain) {
		request.requestStr+="--WebFilterImpl2 ";
		chain.doFilter(request, response, chain);
		response.responseStr+="--WebFilterImpl2 ";
	}

}
