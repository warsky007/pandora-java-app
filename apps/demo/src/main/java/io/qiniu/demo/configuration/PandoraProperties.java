package io.qiniu.demo.configuration;

import io.qiniu.demo.common.entity.pandora.PandoraMode;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@Configuration
@ConfigurationProperties(prefix = "pandora")
public class PandoraProperties {

  @Value("${pandora.url:}")
  private String pandoraUrl;

  @Value("${pandora.mode:local}")
  private PandoraMode mode;

  @Value("${pandora.token:}")
  private String pandoraToken;

  @Value("${server.address:127.0.0.1}")
  private String serverAddress;

  @Value("${server.port:8088}")
  private String serverPort;

  @Value("${pandora.app:demo}")
  private String appName;

  @Value("${pandora.service:demo}")
  private String serviceName;

  public String getPandoraUrl() {
    return pandoraUrl;
  }

  public PandoraMode getMode() {
    return mode;
  }

  public String getPandoraToken() {
    return pandoraToken;
  }

  public String getServerAddress() {
    return serverAddress;
  }

  public String getServerPort() {
    return serverPort;
  }

  public String getAppName() {
    return appName;
  }

  public String getServiceName() {
    return serviceName;
  }

  @Bean
  public static PandoraPropertiesValidator configurationPropertiesValidator() {
    return new PandoraPropertiesValidator();
  }
}
