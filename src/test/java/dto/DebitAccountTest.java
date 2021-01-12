package dto;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.executable.ExecutableValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.Set;

import static dto.Currency.*;
import static org.junit.jupiter.api.Assertions.*;

class DebitAccountTest {

    private static Validator validator;
    private static ExecutableValidator executableValidator;

    @BeforeEach
    void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
        executableValidator = factory.getValidator().forExecutables();
    }

    @Test
    void amountIsNegative() {

        DebitAccount debitAccount = new DebitAccount(
                1,
                "123456789",
                RUB
                );
        debitAccount.setAmount(BigDecimal.valueOf(-1));

        Set<ConstraintViolation<DebitAccount>> constraintViolations =
                validator.validate( debitAccount );

        assertEquals( 1, constraintViolations.size() );
        assertEquals( "must be greater than or equal to 0", constraintViolations.iterator().next().getMessage() );
    }

    @Test
    void withdrawAmountParameterIsNegative() throws Exception {
        DebitAccount object = new DebitAccount(
                1,
                "123456789",
                RUB
        );
        Method method = DebitAccount.class.getMethod( "withdrawAmount", BigDecimal.class );
        Object[] parameterValues = { BigDecimal.valueOf(-1) };
        Set<ConstraintViolation<DebitAccount>> violations = executableValidator.validateParameters(
                object,
                method,
                parameterValues
        );

        assertEquals( 1, violations.size() );
        Class<? extends Annotation> constraintType = violations.iterator()
                .next()
                .getConstraintDescriptor()
                .getAnnotation()
                .annotationType();
        assertEquals( Positive.class, constraintType );
    }

    @Test
    void getCardParameterIsNull() throws Exception {
        DebitAccount object = new DebitAccount(
                1,
                "123456789",
                RUB
        );
        Method method = DebitAccount.class.getMethod( "getCard", String.class );
        Object[] parameterValues = { null };
        Set<ConstraintViolation<DebitAccount>> violations = executableValidator.validateParameters(
                object,
                method,
                parameterValues
        );

        assertEquals( 1, violations.size() );
        Class<? extends Annotation> constraintType = violations.iterator()
                .next()
                .getConstraintDescriptor()
                .getAnnotation()
                .annotationType();
        assertEquals( NotNull.class, constraintType );
    }
}