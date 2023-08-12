package vn.plantpal.mobile_backend.validators;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class EnumValidator implements ConstraintValidator<ValidEnum, String> {
    private Class<? extends Enum<?>> enumSelected;

    @Override
    public void initialize(ValidEnum constraintAnnotation) {
        enumSelected = constraintAnnotation.targetClassType();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if(value == null){
            return true;
        }

        boolean result = false;
        Object[] enumValues = enumSelected.getEnumConstants();

        for(Object enumValue:enumValues){
            if(value.equals(enumValue.toString())){
                result = true;
                break;
            }
        }

        return result;
    }
}