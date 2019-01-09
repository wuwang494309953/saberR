package fgo.saber.commom.shiro;

import com.google.common.collect.Maps;
import fgo.saber.commom.shiro.realm.SaberRealm;
import org.apache.shiro.cache.MemoryConstrainedCacheManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

/**
 * @author zq
 * @date 2018/10/19
 */
@Configuration
public class ShiroConfigure {

    @Bean("shiroFilter")
    public ShiroFilterFactoryBean shiroFilter(@Qualifier("securityManager") SecurityManager manager) {
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();

        bean.setSecurityManager(manager);
        bean.setLoginUrl("/login/not_login");
//        bean.setSuccessUrl("/index");
        bean.setUnauthorizedUrl("/shiro/unauth");


        /*设置自定义的过滤器*/
//        Map<String, Filter> filterMap = Maps.newLinkedHashMap();
//        bean.setFilters(filterMap);

        Map<String, String> filterChainDefinitionMap = Maps.newLinkedHashMap();
        filterChainDefinitionMap.put("/login/*", "anon");
        filterChainDefinitionMap.put("/actuator/*", "anon");
        filterChainDefinitionMap.put("/**", "authc");
        bean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return bean;
    }

    @Bean("saberRealm")
    public SaberRealm saberRealm() {
        SaberRealm realm = new SaberRealm();
        return realm;
    }

    @Bean("securityManager")
    public SecurityManager securityManager(@Qualifier("saberRealm") SaberRealm saberRealm) {
        DefaultWebSecurityManager manager = new DefaultWebSecurityManager();
        manager.setCacheManager(new MemoryConstrainedCacheManager());
        manager.setRealm(saberRealm);
        return manager;
    }

    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(@Qualifier("securityManager") SecurityManager manager) {
        AuthorizationAttributeSourceAdvisor advisor = new AuthorizationAttributeSourceAdvisor();
        advisor.setSecurityManager(manager);
        return advisor;
    }

}
