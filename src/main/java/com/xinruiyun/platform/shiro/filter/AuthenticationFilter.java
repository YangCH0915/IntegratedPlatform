package com.xinruiyun.platform.shiro.filter;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.web.filter.PathMatchingFilter;
import org.apache.shiro.web.util.WebUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuthenticationFilter  extends PathMatchingFilter {

    private String failureUrl;
    private String successUrl;

    @Override
    protected boolean onPreHandle(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {
        if (SecurityUtils.getSubject().isAuthenticated()) {
            return true;
        }
        System.out.println("shiro过滤器");
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        if (isLoginRequest(req)) {
            if ("post".equalsIgnoreCase(req.getMethod())) {
                boolean loginSuccess = login(req);
                if (loginSuccess) {
                    redirectToSuccessUrl(req, resp);
                }
            }else {
                saveRequestAndRedirectToLogin(req, resp);
            }
        }
        return true;
    }

    private boolean redirectToSuccessUrl(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        WebUtils.redirectToSavedRequest(req, resp, successUrl);
        return false;
    }
    private void saveRequestAndRedirectToLogin(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        WebUtils.saveRequest(req);
        WebUtils.issueRedirect(req, resp, failureUrl);
    }
    private boolean login(HttpServletRequest req) {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        try {
            SecurityUtils.getSubject().login(new UsernamePasswordToken(username, password));
        } catch (Exception e) {
            req.setAttribute("shiroLoginFailure", e.getClass());
            return false;
        }
        return true;
    }
    private boolean isLoginRequest(HttpServletRequest req) {
        return pathsMatch(successUrl, WebUtils.getPathWithinApplication(req));
    }
    public String getFailureUrl() {
        return failureUrl;
    }
    public void setFailureUrl(String failureUrl) {
        this.failureUrl = failureUrl;
    }
    public String getSuccessUrl() {
        return successUrl;
    }
    public void setSuccessUrl(String successUrl) {
        this.successUrl = successUrl;
    }
}
