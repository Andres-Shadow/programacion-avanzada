package co.edu.uniquindio.unicine.filtros;

import co.edu.uniquindio.unicine.bean.SeguridadBean;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.FilterChain;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class SeguridadFilter implements Filter {

    public static final String PAGINA_INICIO = "/index.xhtml";

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) {


        try {
            final HttpServletRequest request = (HttpServletRequest) servletRequest;
            final HttpServletResponse response = (HttpServletResponse) servletResponse;
            final String requestURI = request.getRequestURI();
            SeguridadBean userManager = (SeguridadBean) request.getSession().getAttribute("seguridadBean");

            if (requestURI.startsWith("/cliente/") ) {

                if (userManager != null) {
                    if (userManager.isAutenticado() && userManager.getTipoSesion().equals("cliente")) {
                        filterChain.doFilter(servletRequest, servletResponse);
                    } else {
                        response.sendRedirect(request.getContextPath() + PAGINA_INICIO);
                    }
                } else {
                    response.sendRedirect(request.getContextPath() + PAGINA_INICIO);
                }
            }else if (requestURI.startsWith("/admin/") ) {

                if (userManager != null) {
                    if (userManager.isAutenticado() && userManager.getTipoSesion().equals("admin-global")) {
                        filterChain.doFilter(servletRequest, servletResponse);
                    } else {
                        response.sendRedirect(request.getContextPath() + PAGINA_INICIO);
                    }
                } else {
                    response.sendRedirect(request.getContextPath() + PAGINA_INICIO);
                }
            }else if (requestURI.startsWith("/admin_teatro/") ) {

                if (userManager != null) {
                    if (userManager.isAutenticado()) {
                        filterChain.doFilter(servletRequest, servletResponse);
                    } else {
                        response.sendRedirect(request.getContextPath() + PAGINA_INICIO);
                    }
                } else {
                    response.sendRedirect(request.getContextPath() + PAGINA_INICIO);
                }
            }else{
                filterChain.doFilter(servletRequest, servletResponse);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
