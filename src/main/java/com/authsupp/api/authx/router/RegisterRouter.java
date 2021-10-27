package com.authsupp.api.authx.router;

import com.authsupp.api.authx.modules.models.req.RegisterRequestBody;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.*;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Mono;

import com.authsupp.api.authx.modules.models.res.RegisterSuccessResponse;


@Configuration
public class RegisterRouter {

    @Bean
    public RouterFunction<ServerResponse> router() {
        return RouterFunctions.route(
                RequestPredicates.POST("/v1/register")
                        .and(RequestPredicates.accept(MediaType.APPLICATION_JSON)),
                this::route
        );
    }

    private Mono<ServerResponse> route(ServerRequest request) {
        return register(request)
                .flatMap(rp -> ServerResponse.ok().body(
                        Mono.just(rp), RegisterSuccessResponse.class
                ))
                .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.BAD_REQUEST, "bad request: please check the body")));
    }

    private Mono<RegisterSuccessResponse> register(ServerRequest request) {
        Mono<RegisterRequestBody> body = request.bodyToMono(RegisterRequestBody.class);
        RegisterSuccessResponse response = new RegisterSuccessResponse();
        response.setStatus("ok");
        return body.flatMap(b -> Mono.just(response));
    }

}
