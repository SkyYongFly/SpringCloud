package com.example.apigateway.filter;

import com.google.common.base.Utf8;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;

/**
 * Zuul过滤器
 *
 * @author zhuyong
 * @version V1.0.0
 * @date 2018/10/9 13:46
 */
public class AccessFilter extends ZuulFilter{
    /**
     * 过滤器的类型，它决定过滤器在请求的哪个生命周期中执行。
     * 这里定义为pre，代表会在请求被路由之前执行
     *
     * @return
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 过滤器的执行顺序。当请求在一个阶段中存在多个过滤器时，需要根据该方法返回的值来依次执行
     *
     * @return
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 判断该过滤器是否需要被执行。这里我们直接返回了true
     *
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * Zuul过滤器具体逻辑，即具体如何拦截请求进行处理
     *
     * @return
     */
    @Override
    public Object run() {
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();

        //这里测试简单的判断请求参数中是否有token参数决定是否拦截
        Object token = request.getParameter("token");
        if(null == token){
            System.out.println(request.getRequestURL() + ":请求无token，拦截该请求！");
            //Zuul拦截请求
            context.setSendZuulResponse(false);
            //设置返回状态码
            context.setResponseStatusCode(401);
            //设置返回body内容
            try {
                context.getResponse().setCharacterEncoding("UTF-8");
                context.getResponse().setContentType("text/html;charset=UTF-8");
                context.setResponseBody(new String("请求无token，拦截该请求！".getBytes("utf-8")));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            return null;
        }

        System.out.println(request.getRequestURL() + ":请求有token，有效请求！");
        return null;
    }
}
