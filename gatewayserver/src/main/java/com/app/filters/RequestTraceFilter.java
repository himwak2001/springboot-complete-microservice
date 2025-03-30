package com.app.filters;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;


// Responsible for generating trace id or correlation id whenever a new request come to gateway server from external client application
@Order(1)       // order of execution of filter
@Component
public class RequestTraceFilter implements GlobalFilter {       // filter to be executed for all kind of traffic, implement GlobalFilter

    private static final Logger logger = LoggerFactory.getLogger(RequestTraceFilter.class);

    @Autowired
    FilterUtility filterUtility;

    @Override
    // Mono -> Single Object, Flux -> Collection of object
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {        // Reactive programming. Void -> not returning anything, just trying to invoke next filter
        HttpHeaders requestHeaders = exchange.getRequest().getHeaders();
        if (isCorrelationIdPresent(requestHeaders)) {
            logger.debug("greet-welcome-correlation-id found in RequestTraceFilter : {}",
                    filterUtility.getCorrelationId(requestHeaders));
        } else {
            String correlationID = generateCorrelationId();
            exchange = filterUtility.setCorrelationId(exchange, correlationID);
            logger.debug("greet-welcome-correlation-id generated in RequestTraceFilter : {}", correlationID);
        }
        return chain.filter(exchange);      // invoking next filter inside the filter chain
    }

    private boolean isCorrelationIdPresent(HttpHeaders requestHeaders) {
        if (filterUtility.getCorrelationId(requestHeaders) != null) {
            return true;
        } else {
            return false;
        }
    }

    private String generateCorrelationId() {
        return java.util.UUID.randomUUID().toString();
    }

}