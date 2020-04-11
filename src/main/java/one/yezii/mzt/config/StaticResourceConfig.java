package one.yezii.mzt.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.CacheControl;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.io.File;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

@Configuration
public class StaticResourceConfig implements WebMvcConfigurer {
    @Value("${mzt.image-base-path}")
    private String mztImageBasePath;
    @Value("${mzt.url-prefix}")
    private String mztUrlPrefix;
    @Value("${mzt.image-base-path-prod}")
    private String mztImageBasePathProd;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        boolean prod = Optional.ofNullable(System.getProperty("env")).map(s -> s.equals("prod")).orElse(false);
        System.out.println(System.getProperty("env"));
        registry.addResourceHandler(mztUrlPrefix + "/**")
                .addResourceLocations("file:" + (prod ? mztImageBasePathProd : mztImageBasePath) + File.separator)
                .setCacheControl(CacheControl.maxAge(1, TimeUnit.DAYS).cachePublic());
        registry.addResourceHandler("/static/**")
                .addResourceLocations("classpath:/static/")
                .setCacheControl(CacheControl.maxAge(1, TimeUnit.DAYS).cachePublic());
    }
}