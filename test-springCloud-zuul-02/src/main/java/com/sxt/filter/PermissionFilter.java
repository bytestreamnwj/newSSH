package com.sxt.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
/**
 * 权限过滤器
 * 察验请求是否携带权限令牌token，正确放行，错误拦截
 * @author Administrator
 *
 */
public class PermissionFilter extends ZuulFilter{

	@Override
	public boolean shouldFilter() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		RequestContext context = RequestContext.getCurrentContext();
		HttpServletRequest req = context.getRequest();
		HttpServletResponse resp = context.getResponse();
		resp.setContentType("text/html;charset=UTF-8");
		String token = req.getParameter("token");
		if(StringUtils.isBlank(token) || !"123".equals(token)) {
			//不再进行路由
			context.setSendZuulResponse(false);
			//设置错误响应码
			context.setResponseStatusCode(403);
			//响应错误信息
			context.setResponseBody("权限不足...");
			//resp.getWriter().write("权限不足...");

		}
		return null;
	}

	@Override
	public String filterType() {
		// TODO Auto-generated method stub
		return "pre";
	}

	@Override
	public int filterOrder() {
		// TODO Auto-generated method stub
		return 0;
	}

}
