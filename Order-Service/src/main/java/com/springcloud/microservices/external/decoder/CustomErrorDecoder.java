package com.springcloud.microservices.external.decoder;

import java.io.IOException;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.springcloud.microservices.exception.NotFoundException;
import com.springcloud.microservices.external.exception.ErrorResponse;

import feign.Response;
import feign.codec.ErrorDecoder;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Component
public class CustomErrorDecoder implements ErrorDecoder {

	@Override
	public Exception decode(String methodKey, Response response) {
		ObjectMapper objectMapper = new ObjectMapper();
		log.info("::{}",response.request().url());
		log.info("::{}",response.request().headers());
		
		try {
            ErrorResponse errorResponse
                    = objectMapper.readValue(response.body().asInputStream(),
                    ErrorResponse.class);

            return new NotFoundException(errorResponse.getErrorMessage() ,
                    errorResponse.getErrorCode(),
                    response.status());

        } catch (IOException e) {
            throw  new NotFoundException("Internal Server Error",
                    "INTERNAL_SERVER_ERROR",
                    500);
        }
	}

}
