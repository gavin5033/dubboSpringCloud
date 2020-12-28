package com.gavin.study;

import com.alibaba.csp.sentinel.adapter.spring.webmvc.callback.BlockExceptionHandler;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.fastjson.JSON;
import com.gavin.study.enums.BizCodeEnume;
import com.gavin.study.vo.ResponseDTO;
import org.springframework.context.annotation.Configuration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * class description
 *
 * @author wangbingchang
 * @date 2020/12/28
 */

@Configuration
public class SeckillSentinelConfig implements BlockExceptionHandler {
    /**
     * 2.2.0以后的版本实现的是BlockExceptionHandler；以前的版本实现的是WebCallbackManager
     * @param httpServletRequest
     * @param httpServletResponse
     * @param e
     * @throws Exception
     */
    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, BlockException e) throws Exception {
        ResponseDTO responseDTO = ResponseDTO.builder().success(true).code(BizCodeEnume.TOO_MANY_REQUESTS_EXCEPTION.getCode()).msg(BizCodeEnume.TOO_MANY_REQUESTS_EXCEPTION.getDesc()).build();
        httpServletResponse.setCharacterEncoding("UTF-8");
        httpServletResponse.setContentType("application/json");
        httpServletResponse.getWriter().write(JSON.toJSONString(responseDTO));
    }
}

