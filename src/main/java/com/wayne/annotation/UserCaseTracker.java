package com.wayne.annotation;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Method;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 注解处理器
 * @author wayne
 */
@Slf4j
public class UserCaseTracker {

    public static void trackUseCases(List<Integer> useCases, Class<?> cl){
        Method[] declaredMethods = cl.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            UseCase useCase = declaredMethod.getAnnotation(UseCase.class);
            if(useCase != null){
                log.info("id【{}】，description【{}】",useCase.id(), useCase.description());
                useCases.remove(Integer.valueOf(useCase.id()));
            }
        }
        useCases.forEach(i -> log.info("Missing use case【{}】", i));
    }

    public static void main(String[] args) {
        List<Integer> useCases = IntStream.range(47, 51)
                .boxed().collect(Collectors.toList());
        trackUseCases(useCases, PasswordUtils.class);
    }
}
