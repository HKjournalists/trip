
package com.otrip.webservice.util;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;



/**
 * Annotation used on web service interfaces, to restrict the access based on {@link ServiceOperation}
 * 
 * @author ZHONGjC
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Permission {
    ServiceOperation[] value() default {};
}
