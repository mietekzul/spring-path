package pl.raziel.filters;

import com.netflix.zuul.ZuulFilter;

public class MyZuulFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        System.out.println("This request has passed through the custom Zuul Filter...");
        return null;
    }
}
