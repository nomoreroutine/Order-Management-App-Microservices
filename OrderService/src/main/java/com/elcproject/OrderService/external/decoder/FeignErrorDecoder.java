package com.elcproject.OrderService.external.decoder;

import com.elcproject.OrderService.exception.InsufficientStockException;
import com.elcproject.OrderService.exception.ServiceNotAvailableException;
import com.elcproject.OrderService.exception.UnknownException;

import feign.Response;
import feign.codec.ErrorDecoder;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class FeignErrorDecoder implements ErrorDecoder {

    @Override
    public Exception decode(String key, Response response) {

        if(response.status() == HttpStatus.UNPROCESSABLE_ENTITY.value())
            return new InsufficientStockException();
        else if(response.status() == HttpStatus.SERVICE_UNAVAILABLE.value())
            return new ServiceNotAvailableException("");

        return new UnknownException("An unexpected error occurred.");
    }
}
