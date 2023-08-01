package br.com.softexpert.desafio.validator.util;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ValidationException;

public class ValidationBuilder {
	
	@SuppressWarnings("rawtypes")
	private List<ValidationRule> rules = new ArrayList<>();
	
    public ValidationBuilder() {
		
	}
   
	@SuppressWarnings({ "rawtypes" })
    public ValidationBuilder add(ValidationRule rule) {
        this.rules.add(rule);
        return this;
    }
	
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public List<String> evaluate() {
    	List<String> messages = new ArrayList<>();
        for (ValidationRule rule : this.rules) {
            if (rule.getValidation().isInvalid(rule.getValue())) {
                messages.add(rule.getMessage());
            }
        }
        return messages;
    }
	
    public void evaluateFieldsAndThrows() {
        List<String> messages = this.evaluate();
        if (!messages.isEmpty()) {
        	for (String message : messages) {
        		throw new ValidationException(message);
        	}
        }
    }

}
