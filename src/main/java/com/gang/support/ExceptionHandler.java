package com.gang.support;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import com.gang.util.XkbException;


public class ExceptionHandler extends SimpleMappingExceptionResolver {

	public static final Log log = LogFactory.getLog(ExceptionHandler.class); 
	@Override
	protected ModelAndView doResolveException(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex) {
		
			log.error(ex.getMessage());
	        boolean isView = request.getRequestURL().toString().contains(".view");
	        if (isView)
	        	return super.doResolveException(request, response, handler, ex);
	        String message = "未知异常，请稍后再试";
	        if (ex instanceof XkbException) {
	        	message = ex.getMessage();
	        }
	        
	        ModelAndView mav = new ModelAndView();
	        mav.setView(new MappingJackson2JsonView());
            mav.addObject("code", 0);
            mav.addObject("status", false);
            mav.addObject("msg", message);
            mav.addObject("data", null);
	        return mav;
	}
}
