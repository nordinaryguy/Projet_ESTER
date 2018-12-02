package fr.univangers.ester.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.univangers.ester.beans.UtilisateurBeans;

@WebFilter("/utilisateur/*")
public class UtilisateurFilter implements Filter {

    public static final String ACCES_CONNEXION  = "/connexion";
    public static final String ATT_SESSION_USER = "sessionUtilisateur";
    
    public UtilisateurFilter() {
    }

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        /* Cast des objets request et response */
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        /* Récupération de la session depuis la requête */
        HttpSession session = req.getSession();
        
        UtilisateurBeans sessionUser = (UtilisateurBeans) session.getAttribute(ATT_SESSION_USER);
        if (sessionUser != null && sessionUser.isUtilisateur()) {
            /* Affichage de la page restreinte */
            chain.doFilter( req, res );
        } else {
            /* Redirection vers la page publique */
        	req.getRequestDispatcher(ACCES_CONNEXION).forward( req, res );
        }
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
