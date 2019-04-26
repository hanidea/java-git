package com.example.firstapp.config;

import com.example.firstapp.domain.User;
import com.example.firstapp.repository.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;

import java.util.Collection;
/**
 * <br>
 * 标题: 路由器函数配置<br>
 * 描述: 配置映射<br>
 *
 * @author James
 * @date 2019/04/26
 */
@Configuration
public class RouterFunctionConfiguration {
    /**
     * 请求接口： ServletRequest 或者 HttpServletRequest
     * 响应接口： ServeletResponse 或者 HttpServletResponse
     * spring 5
     * 请求接口：ServerRequest
     * 响应接口：ServerResponse
     * 即可支持 Servlet 规范，也可以支持自定义，不如 Netty(web Server)
     * 以本例
     * 定义 GET 请求，并且放回所有的用户对象 URI：/person/find/all
     * Flux 是 0 - N 个对象集合
     * Mono 是 0 - 1 个对象集合
     * Reactive 中的 Flux 或者 Mono 是异步处理（非阻塞）
     * 集合对象基本上是同步处理（阻塞）
     * Flux 或者 Mono 都是 Publisher
     */
    @Bean
    public RouterFunction<ServerResponse> personFindAll(UserRepository userRepository){
        return RouterFunctions.route(RequestPredicates.GET("/person/find/all"),
                request -> {
                    //返回所有用户对象
                    Collection<User> users = userRepository.findAll();
                    Flux<User> userFlux = Flux.fromIterable(users);
                    return ServerResponse.ok().body(userFlux,User.class);
                });
    }
}