package cn.ouyangfan.mall.sibo.admin.controller;

import cn.ouyangfan.mall.sibo.admin.TokenInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.security.core.context.SecurityContextHolder;
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

    /**
     *  获取token的地址
     */
    @Value("${sso.token.url}")
    private String oauthServiceUrl;

    /**
     *  admin的回调函数地址
     */
    @Value("${sso.callback.url}")
    private String callbackUrl;


    private RestTemplate restTemplate = new RestTemplate();

    @GetMapping("/oauth/callback")
    public void callback(@RequestParam(required = false) String code, String state, HttpServletRequest request, HttpServletResponse response) throws IOException {
        log.info("根据授权码获取token");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.setBasicAuth("04e6337ae6c7435d8b2eda995878fe0e", "04e6337ae6c7435d8b2eda995878fe0e");
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("code", code);
        params.add("grant_type", "authorization_code");
        params.add("redirect_uri", callbackUrl);
        HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(params, headers);

        ResponseEntity<TokenInfo> token = restTemplate.exchange(oauthServiceUrl, HttpMethod.POST, entity, TokenInfo.class);
        log.info("token is:" + token.getBody());
        System.err.println(token.getBody().getAccess_token());
    }

    @GetMapping("/me")
    public Object getCurrentUser() {
        return SecurityContextHolder.getContext().getAuthentication();
    }


}
