package br.com.github.davimc.ItSupport.services.exceptions;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

public class InternalValidationException extends RuntimeException{

    public InternalValidationException(List<String> errors) {
        super(buildErrorMessage(errors));
    }

    private static String buildErrorMessage(List<String> errors) {
        return "Founded Errors {\n" + String.join(", \n", errors) +
                "\n}";
    }


}
