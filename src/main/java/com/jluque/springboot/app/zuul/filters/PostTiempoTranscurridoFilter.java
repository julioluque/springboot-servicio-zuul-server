package com.jluque.springboot.app.zuul.filters;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class PostTiempoTranscurridoFilter extends ZuulFilter {

	private static final Logger log = LoggerFactory.getLogger(PostTiempoTranscurridoFilter.class);

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() throws ZuulException {

		RequestContext context = RequestContext.getCurrentContext();
		HttpServletRequest request = context.getRequest();

		log.info("Entrando a post filter...");

		Long tiempoInicio = (Long) request.getAttribute("tiempoInicio");
		Long tiempoFin = System.currentTimeMillis();
		Long tiempoTranscurrido = tiempoInicio - tiempoFin;
		
		log.info(String.format("Tiempo trancurrido en segundos: %s", tiempoTranscurrido.doubleValue()/1000.00));
		log.info(String.format("Tiempo trancurrido en milisegundos: %s", tiempoTranscurrido));
		return null;
	}

	@Override
	public String filterType() {
		return "post";
	}

	@Override
	public int filterOrder() {
		// TODO Auto-generated method stub
		return 3;
	}

}
