package com.itmuch.cloud.feign;

import org.springframework.cloud.netflix.feign.FeignClient;

import com.itmuch.cloud.entity.User;
import com.itmuch.config.Configuration1;

import feign.Param;
import feign.RequestLine;
/**
 *自定义feign配置
 */
@FeignClient(name = "microservice-provider-user", configuration = Configuration1.class)
public interface UserFeignClient {
	/**
	 *请求方法和路径 
	 */
	 // 两个坑：1. @GetMapping不支持   2. @PathVariable得设置value
  @RequestLine("GET /simple/{id}")
  public User findById(@Param("id") Long id);
}
