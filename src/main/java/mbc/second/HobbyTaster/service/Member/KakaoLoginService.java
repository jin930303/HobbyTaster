package mbc.second.HobbyTaster.service.Member;

import io.netty.handler.codec.http.HttpHeaderValues;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mbc.second.HobbyTaster.dto.Member.KakaoInfoDTO;
import mbc.second.HobbyTaster.dto.Member.KakaoTokenDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Slf4j
@RequiredArgsConstructor
@Service
public class KakaoLoginService {
    private static String clientId;
    private static String KAUTH_TOKEN_URL_HOST = "";
    private static String KAUTH_USER_URL_HOST;

    @Autowired
    public KakaoLoginService(@Value("${kakao.client_id}") String clientId) {
        this.clientId = clientId;
        KAUTH_TOKEN_URL_HOST ="https://kauth.kakao.com";
        KAUTH_USER_URL_HOST = "https://kapi.kakao.com";
    }

    public static String getAccessTokenFromKakao(String code) {

        KakaoTokenDTO dto = WebClient.create(KAUTH_TOKEN_URL_HOST).post()
                .uri(uriBuilder -> uriBuilder
                        .scheme("https")
                        .path("/oauth/token")
                        .queryParam("grant_type", "authorization_code")
                        .queryParam("client_id", clientId)
                        .queryParam("code", code)
                        .build(true))
                .header(HttpHeaders.CONTENT_TYPE, HttpHeaderValues.APPLICATION_X_WWW_FORM_URLENCODED.toString())
                .retrieve()
                //TODO : Custom Exception
                .onStatus(HttpStatusCode::is4xxClientError, clientResponse -> Mono.error(new RuntimeException("Invalid Parameter")))
                .onStatus(HttpStatusCode::is5xxServerError, clientResponse -> Mono.error(new RuntimeException("Internal Server Error")))
                .bodyToMono(KakaoTokenDTO.class)
                .block();


        log.info("[Kakao Service] Access Token ------> {}", dto.getAccessToken());
        log.info("[Kakao Service] Refresh Token ------> {}", dto.getRefreshToken());
        //제공 조건: OpenID Connect가 활성화 된 앱의 토큰 발급 요청인 경우 또는 scope에 openid를 포함한 추가 항목 동의 받기 요청을 거친 토큰 발급 요청인 경우
        log.info("[Kakao Service] Id Token ------> {}", dto.getIdToken());
        log.info("[Kakao Service] Scope ------> {}", dto.getScope());

        return dto.getAccessToken();
    }

    public static KakaoInfoDTO getUserInfo(String accessToken) {

        KakaoInfoDTO userInfo = WebClient.create(KAUTH_USER_URL_HOST)
                .get()
                .uri(uriBuilder -> uriBuilder
                        .scheme("https")
                        .path("/v2/user/me")
                        .build(true))
                .header(HttpHeaders.AUTHORIZATION, "Bearer " + accessToken) // access token 인가
                .header(HttpHeaders.CONTENT_TYPE, HttpHeaderValues.APPLICATION_X_WWW_FORM_URLENCODED.toString())
                .retrieve()
                //TODO : Custom Exception
                .onStatus(HttpStatusCode::is4xxClientError, clientResponse -> Mono.error(new RuntimeException("Invalid Parameter")))
                .onStatus(HttpStatusCode::is5xxServerError, clientResponse -> Mono.error(new RuntimeException("Internal Server Error")))
                .bodyToMono(KakaoInfoDTO.class)
                .block();

        log.info("[Kakao Service] Auth ID ---> {} ", userInfo.getId());
        log.info("[Kakao Service] NickName ---> {} ", userInfo.getKakaoAccount().getProfile().getNickname());
        log.info("[Kakao Service] ProfileImageUrl ---> {} ", userInfo.getKakaoAccount().getProfile().getProfileImageUrl());
        log.info("[Kakao Service] Email ---> {} ", userInfo.getKakaoAccount().getEmail());

        return userInfo;
    }
}

