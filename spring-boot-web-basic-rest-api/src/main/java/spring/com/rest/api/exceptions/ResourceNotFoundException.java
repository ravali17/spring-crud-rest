package spring.com.rest.api.exceptions;

import lombok.Data;

@Data
public class ResourceNotFoundException extends RuntimeException{
    String ResourceName;
    String FieldName;
    int FieldValue;
    
    
    public ResourceNotFoundException(String resourceName, String fieldName, int fieldValue) {
        super(String.format("%s not found  with %s:%d", resourceName, fieldName, fieldValue));
        ResourceName = resourceName;
        FieldName = fieldName;
        FieldValue = fieldValue;
    }


   
}

