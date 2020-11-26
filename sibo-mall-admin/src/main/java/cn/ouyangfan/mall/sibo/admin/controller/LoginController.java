package cn.ouyangfan.mall.sibo.admin.controller;

import cn.ouyangfan.mall.sibo.admin.TokenInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
//import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@RestController
public class LoginController {


    @Value("${sso.token-url}")
    private String oauthServiceUrl;

    /**
     * 获取token的地址
     */
    @Value("${sso.authorize-url}")
    private String authorizeUrl;

    /**
     * admin的回调函数地址
     */
    @Value("${sso.callback-url}")
    private String callbackUrl;

    @Value("${sso.client-id}")
    private String clientId;

    @Value("${sso.client-secret}")
    private String clientSecret;

    @Value("${sso.scope}")
    private String scope;

    @Value("${sso.front-page}")
    private String frontPage;


    private RestTemplate restTemplate = new RestTemplate();


    @GetMapping("/admin/login")
    public void adminSSO(HttpServletRequest request, HttpServletResponse response) throws IOException {
        StringBuffer ssoUrl = new StringBuffer(authorizeUrl + "?response_type=code");
        ssoUrl.append("&client_id=" + clientId)
                .append("&scope=" + scope)
                .append("&redirect_uri=" + callbackUrl);
        response.sendRedirect(ssoUrl.toString());
    }

    @GetMapping("/oauth/callback")
    public void callback(@RequestParam(required = false) String code, String state, HttpServletRequest request, HttpServletResponse response) throws IOException {
        log.info("根据授权码获取token");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.setBasicAuth(clientId, clientSecret);
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("code", code);
        params.add("grant_type", "authorization_code");
        params.add("redirect_uri", callbackUrl);
        HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(params, headers);

        ResponseEntity<TokenInfo> tokenResponse = restTemplate.exchange(oauthServiceUrl, HttpMethod.POST, entity, TokenInfo.class);
        log.info("获取token接口返回的信息是:{}", tokenResponse.toString());
        if (tokenResponse.getStatusCode() != HttpStatus.OK) {
            response.sendRedirect(frontPage + "?code=500&errMessage=获取token信息失败！");
        }
        response.sendRedirect(frontPage + "?code=200&token=" + tokenResponse.getBody().getAccess_token()
                + "&refreshToken=" + tokenResponse.getBody().getRefresh_token());
    }

    @GetMapping("/me")
    public Object getCurrentUser() {
//        return SecurityContextHolder.getContext().getAuthentication();
        return null;
    }


}
