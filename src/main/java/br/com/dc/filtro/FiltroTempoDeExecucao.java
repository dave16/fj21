package br.com.dc.filtro;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class FiltroTempoDeExecucao implements Filter{

	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain filtro) throws IOException, ServletException {
		long tempoInicial = System.currentTimeMillis();
		
		filtro.doFilter(request, response);
		
		long tempoFinal = System.currentTimeMillis();
		String uri = ((HttpServletRequest)request).getRequestURI();
		System.out.println("Tempo de requisica de " + uri + "demorou (ms) " + (tempoFinal - tempoInicial) );
		
	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	
}
