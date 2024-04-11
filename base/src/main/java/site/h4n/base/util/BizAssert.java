package site.h4n.base.util;

import site.h4n.base.exception.H4nRuntimeException;

import java.util.Objects;

public class BizAssert {

    public static void isTrue(Boolean flag,String errMessageTemplate,Object... args){
        if (Boolean.FALSE.equals(flag) || Objects.isNull(flag)){
            final String errMessage = String.format(errMessageTemplate,args);
            throw new H4nRuntimeException(errMessage);
        }
    }

    public static void isFalse(Boolean flag,String errMessageTemplate,Object... args){
         isTrue(!flag, errMessageTemplate, args);
    }


    public static void notNull(Object object,String errMessageTemplate,Object... args){
        isTrue(Objects.nonNull(object), errMessageTemplate, args);
    }
}
