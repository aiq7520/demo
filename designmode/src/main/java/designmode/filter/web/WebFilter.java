package designmode.filter.web;

public interface WebFilter {
	void doFilter(Request request,Response response,WebFilterChain chain);
}
