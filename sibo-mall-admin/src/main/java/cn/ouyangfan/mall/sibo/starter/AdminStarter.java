package cn.ouyangfan.mall.sibo.starter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.*;
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
@SpringBootApplication(scanBasePackages = {"cn.ouyangfan.mall.sibo"})
public class AdminStarter {

    private RestTemplate restTemplate = new RestTemplate();

    public static void main(String[] args) {
        SpringApplication.run(AdminStarter.class, args);
    }
    

    @GetMapping("/oauth/callback")
    public void callback(@RequestParam(required = false) String code, String state, HttpServletRequest request, HttpServletResponse response) throws IOException {

        log.info("state is " + state);

        String oauthServiceUrl = "http://127.0.0.1:9999/oauth/token";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.setBasicAuth("04e6337ae6c7435d8b2eda995878fe0e", "04e6337ae6c7435d8b2eda995878fe0e");

        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("code", code);
        params.add("grant_type", "authorization_code");
        params.add("redirect_uri", "http://admin.ouyangfan.cn:9090/oauth/callback");

        HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(params, headers);

        ResponseEntity<TokenInfo> token = restTemplate.exchange(oauthServiceUrl, HttpMethod.POST, entity, TokenInfo.class);
        System.out.println("token is:" + token.getBody());
        System.out.println("token is:" + token.getBody().getAccess_token());
    }


}
