package com.devitwithgreg.website.helper;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.http.*;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;
import java.util.Collections;
import java.util.Map;

public class WebserviceHelper {

    public static String UTF8 = "UTF-8";
    public static String USER_AGENT = "User-Agent";
    public static String USER_AGENT_VALUE = "Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36";
    public static String WEB_SEPARATOR = "/";
    public static String WEB_QUERY_BEGIN = "?";
    public static String WEB_QUERY_EQUAL = "=";
    public static String WEB_QUERY_SEPARATOR = "&";

    /**
     * handle the content type of the request
     *
     * @param httpHeaders the request header
     */
    private static void handleHeaderContentType(@NotEmpty HttpHeaders httpHeaders) {
        httpHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON_UTF8));
        httpHeaders.setContentType(
            new MediaType(
                MediaType.APPLICATION_JSON.getType(),
                MediaType.APPLICATION_JSON.getSubtype(),
                Charset.forName(UTF8)));
    }

    /**
     * create the header for the request
     *
     * @return the request header
     */
    public static HttpHeaders createHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAcceptCharset(Collections.singletonList(Charset.forName(UTF8)));
        handleHeaderContentType(headers);
        headers.add(USER_AGENT, USER_AGENT_VALUE);
        headers.set("X-HTTP-Method-Override", "GET");
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        return headers;
    }

    public static RestTemplate createRestTemplate() {
        RestTemplate template = new RestTemplate();
        template.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        return template;
    }

    public static String buildYoutubeUrl(@NotEmpty final String baseUrl, @NotEmpty final String service, @NotEmpty final Map<String, String> query, @NotEmpty String apiKey) {
        StringBuilder builder = new StringBuilder(baseUrl);
        if (!baseUrl.endsWith(WEB_SEPARATOR)) {
            builder.append(WEB_SEPARATOR);
        }

        builder.append(service);
        if (!service.endsWith(WEB_QUERY_BEGIN)) {
            builder.append(WEB_QUERY_BEGIN);
        }

        query.forEach((parameter, value) -> builder.append(parameter)
            .append(WEB_QUERY_EQUAL)
            .append(value)
            .append(WEB_QUERY_SEPARATOR));

        builder.append("key")
            .append(WEB_QUERY_EQUAL)
            .append(apiKey);

        return builder.toString();
    }


}
