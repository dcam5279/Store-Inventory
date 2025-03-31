package com.example.demo.validators;

import com.example.demo.domain.Part;
import com.example.demo.domain.Product;
import com.example.demo.service.ProductService;
import com.example.demo.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 *
 *
 *
 *
 */
public class EnufPartsValidator implements ConstraintValidator<ValidEnufParts, Product> {
    @Autowired
    private ApplicationContext context;
    public static  ApplicationContext myContext;
    @Override
    public void initialize(ValidEnufParts constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Product product, ConstraintValidatorContext constraintValidatorContext) {
        if(context==null) return true;
        if(context!=null)myContext=context;
        ProductService repo = myContext.getBean(ProductServiceImpl.class);
        if (product.getId() != 0) {
            Product myProduct = repo.findById((int) product.getId());
            for (Part p : myProduct.getParts()) {

                Integer minInv = p.getMinInv();
                Integer maxInv = p.getMaxInv();
                Integer inv = p.getInv();

                if (minInv == null || maxInv == null || inv == null) {
                    constraintValidatorContext.disableDefaultConstraintViolation();
                    constraintValidatorContext.buildConstraintViolationWithTemplate(
                                    "Part '" + p.getName() + "' has missing inventory values (Min, Max, or Inventory is null).")
                            .addConstraintViolation();
                    return false;
                }

                if (p.getInv() < p.getMinInv()) {
                    constraintValidatorContext.disableDefaultConstraintViolation();
                    constraintValidatorContext.buildConstraintViolationWithTemplate(
                                    "Part '" + p.getName() + "' has inventory below the minimum allowed!")
                            .addConstraintViolation();
                    return false;
                }

                if (p.getInv() > p.getMaxInv()) {
                    constraintValidatorContext.disableDefaultConstraintViolation();
                    constraintValidatorContext.buildConstraintViolationWithTemplate(
                                    "Part '" + p.getName() + "' has inventory above the maximum allowed!")
                            .addConstraintViolation();
                    return false;
                }

                if (p.getInv() - (product.getInv() - myProduct.getInv()) < p.getMinInv()) {
                    constraintValidatorContext.disableDefaultConstraintViolation();
                    constraintValidatorContext.buildConstraintViolationWithTemplate(
                                    "Adding/updating this product will cause the inventory of part '" + p.getName() +
                                            "' to fall below the minimum allowed!")
                            .addConstraintViolation();
                    return false;
                }
            }
            return true;
        }
        return true;
    }
}