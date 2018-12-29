package fgo.saber.auth.provider.shiro;

import com.google.common.collect.Maps;
import fgo.saber.auth.provider.shiro.realm.HmacRealm;
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
        bean.setLoginUrl("/auth/not_login");
//        bean.setSuccessUrl("/index");
        bean.setUnauthorizedUrl("/auth/not_auth");

//        Map<String, String> filterChainDefinitionMap = myShiroService.initFilterMap();

        /*filterChainDefinitionMap.put("/test/testRole", "roles[adminm]");
        filterChainDefinitionMap.put("/admin","roles[admin,么么]");
        filterChainDefinitionMap.put("/edit", "perms[edit]");*/

        /*设置自定义的过滤器*/
//        Map<String, Filter> filterMap = Maps.newLinkedHashMap();
//        filterMap.put("hmac", new HmacFilter());
//        bean.setFilters(filterMap);

        Map<String, String> filterChainDefinitionMap = Maps.newLinkedHashMap();
        filterChainDefinitionMap.put("/actuator/*", "anon");
        filterChainDefinitionMap.put("/auth/login", "anon");
//        filterChainDefinitionMap.put("/**", "authc");
        bean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return bean;
    }


    @Bean("securityManager")
    public SecurityManager securityManager(@Qualifier("hmacRealm") HmacRealm myRealm) {
        DefaultWebSecurityManager manager = new DefaultWebSecurityManager();
        manager.setCacheManager(new MemoryConstrainedCacheManager());
        manager.setRealm(myRealm);
        return manager;
    }

    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(@Qualifier("securityManager") SecurityManager manager) {
        AuthorizationAttributeSourceAdvisor advisor = new AuthorizationAttributeSourceAdvisor();
        advisor.setSecurityManager(manager);
        return advisor;
    }

}
