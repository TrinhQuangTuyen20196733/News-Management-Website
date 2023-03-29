package vn.com.standford.springmvcbasic1.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import vn.com.standford.springmvcbasic1.util.SecurityUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Component
public class CustomSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    @Override
    public RedirectStrategy getRedirectStrategy() {
        return redirectStrategy;
    }

    @Override
    public void setRedirectStrategy(RedirectStrategy redirectStrategy) {
        this.redirectStrategy = redirectStrategy;
    }

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
            throws IOException {
        String targetUrl = determineTargetUrl(authentication);
        if (response.isCommitted()) {
            return;
        }
        redirectStrategy.sendRedirect(request, response, targetUrl);
    }

    private String determineTargetUrl(Authentication authentication) {
        String url = "";
        List<String> Roles = SecurityUtils.getAuthorities();
        // if Role is Admin redirect to /quan-tri/trang-chu
        if (isAdmin(Roles)) {
            url="/quan-tri/trang-chu";
        } else if (isUser(Roles)){
            url="/trang-chu";
        }
        // if Role is User redirect to /trang-chu
        return url;
    }

    private boolean isAdmin(List<String> Roles) {
        return Roles.contains("ADMIN");
    }

    private boolean isUser(List<String> Roles) {
        return Roles.contains("USER");
    }
}
