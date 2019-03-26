package gree.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * @author charleslai@139.com
 * @Title: SessionConfig
 * @ProjectName eladmin
 * @Description: TODO
 * @date 2019-03-2608:53
 */
@Configuration
@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 86400 * 30)
public class SessionConfig {
}
