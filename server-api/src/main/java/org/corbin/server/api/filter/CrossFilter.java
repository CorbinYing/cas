//package org.common.server.api.filter;
///**
// * 配置过滤器，过滤用户的请求，只允许特定的请求方式通过
// * 也可以使用拦截器、@CrossOrgin实现
// *
// * @author yin
// * @date 2019/05/27
// */
//
//import javax.servlet.*;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//public class CrossFilter implements Filter {
//
//    @Override
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
//        //解决跨域
//        httpServletResponse.setHeader("Access-Control-Allow-Origin", "*");
//
//       // httpServletResponse.setHeader("Access-Control-Allow-Origin", "<请求方域名如:http://www.sohu.com>");
//        httpServletResponse.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, OPTIONS, DELETE");
//        httpServletResponse.setHeader("Access-Control-Max-Age", "3600");
//        httpServletResponse.setHeader("Access-Control-Allow-Headers", "x-requested-with, Content-Type");
//        httpServletResponse.setHeader("Access-Control-Allow-Credentials", "true");
//
//        chain.doFilter(request, response);
//    }
//
//}
