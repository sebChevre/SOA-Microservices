package ch.dso.apigateway;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * Exemple de récupération de propriété décentralisé sur consul<br/>
 * KeyValue consul: config/gateway/{clé}
 *
 */
@Getter
@Setter
@Component
@RefreshScope
@Configuration
@ConfigurationProperties
public class ConsulProperties {
    private String test;
}
