package fgo.saber.shiro;

import com.google.common.collect.Maps;
import fgo.saber.shiro.extension.SbPermissions;
import fgo.saber.shiro.filter.SaberFormAuthenticationFilter;
import fgo.saber.shiro.filter.SaberPermissionsAuthorizationFilter;
import fgo.saber.shiro.realm.SaberRealm;
import fgo.saber.shiro.sessionmanager.SaberWebSessionManager;
import org.apache.shiro.cache.MemoryConstrainedCacheManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
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
//        bean.setLoginUrl("/shiro/login");
//        bean.setSuccessUrl("/index");
//        bean.setUnauthorizedUrl("/shiro/unauth");

//        Map<String, String> filterChainDefinitionMap = myShiroService.initFilterMap();

        /*filterChainDefinitionMap.put("/test/testRole", "roles[adminm]");
        filterChainDefinitionMap.put("/admin","roles[admin,么么]");
        filterChainDefinitionMap.put("/edit", "perms[edit]");*/

        //设置自定义的过滤器
        Map<String, Filter> filterMap = Maps.newLinkedHashMap();
        filterMap.put("authc", new SaberFormAuthenticationFilter());
        filterMap.put("perms", new SaberPermissionsAuthorizationFilter());
        bean.setFilters(filterMap);

        /*Map<String, String> filterChainDefinitionMap = Maps.newLinkedHashMap();
        filterChainDefinitionMap.put("/actuator/*", "anon");

        filterChainDefinitionMap.put("/auth/*", "anon");
        filterChainDefinitionMap.put("/**", "authc");
        bean.setFilterChainDefinitionMap(filterChainDefinitionMap);*/

        return bean;
    }

    @Bean
    public SaberRealm saberRealm() {
        return new SaberRealm();
    }

    @Bean
    public SaberWebSessionManager saberWebSessionManager() {
        return new SaberWebSessionManager();
    }

    @Bean("securityManager")
    public SecurityManager securityManager(SaberRealm saberRealm, SaberWebSessionManager saberWebSessionManager) {
        DefaultWebSecurityManager manager = new DefaultWebSecurityManager();
        manager.setCacheManager(new MemoryConstrainedCacheManager());
        manager.setRealm(saberRealm);
        manager.setSessionManager(saberWebSessionManager);
        return manager;
    }

    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(@Qualifier("securityManager") SecurityManager manager) {
        AuthorizationAttributeSourceAdvisor advisor = new AuthorizationAttributeSourceAdvisor();
        advisor.setSecurityManager(manager);
        return advisor;
    }

    @Bean
    public SbPermissions sbPermissions() {
        return new SbPermissions();
    }

}
