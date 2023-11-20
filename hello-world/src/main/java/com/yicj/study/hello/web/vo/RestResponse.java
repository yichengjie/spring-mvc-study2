package com.yicj.study.hello.web.vo;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * RestResponse
 * </p>
 *
 * @author yicj
 * @since 2023年11月20日 11:11
 */
@Data
public class RestResponse<T> {

    private String code ;

    private String massage ;

    private T data ;

    public static <T> RestResponse<T> success(T data){
        RestResponse<T> restResponse = new RestResponse<>() ;
        restResponse.setCode("00000");
        restResponse.setData(data);
        return restResponse ;
    }

    public static <T> RestResponse<T> fail(String code, String massage){
        RestResponse<T> restResponse = new RestResponse<>() ;
        restResponse.setCode(code);
        restResponse.setMassage(massage);
        return restResponse ;
    }


    public static <T> RestResponse<T> fail(String massage){
        RestResponse<T> restResponse = new RestResponse<>() ;
        restResponse.setMassage(massage);
        return restResponse ;
    }

    public Map<String, Object> toMap(){
        Map<String, Object> retMap = new HashMap<>() ;
        retMap.put("code", this.getCode()) ;
        retMap.put("massage", this.getMassage()) ;
        retMap.put("data", this.getData()) ;
        return retMap ;
    }
}
