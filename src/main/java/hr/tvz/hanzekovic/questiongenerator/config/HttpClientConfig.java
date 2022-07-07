package hr.tvz.hanzekovic.questiongenerator.config;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HttpClientConfig {

    @Value("${httpclient.request-timeout}")
    private int requestTimeout;

    @Value("${httpclient.connect-timeout}")
    private int connectTimeout;

    @Value("${httpclient.socket-timeout}")
    private int socketTimeout;

    @Bean
    public CloseableHttpClient httpClient() {
        final RequestConfig requestConfig = RequestConfig.custom()
                .setConnectionRequestTimeout(requestTimeout)
                .setConnectTimeout(connectTimeout)
                .setSocketTimeout(socketTimeout)
                .build();

        return HttpClients.custom()
                .setDefaultRequestConfig(requestConfig)
                .build();
    }

}
