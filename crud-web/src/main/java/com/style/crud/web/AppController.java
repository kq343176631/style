package com.style.crud.web;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.google.common.collect.Maps;
import com.style.basic.constant.ErrorCode;
import com.style.basic.model.Result;
import org.springframework.beans.factory.annotation.Value;

import java.util.Map;

/**
 * 适用于移动端（REST）
 */
public abstract class AppController extends BaseController {

    /**
     * 管理基础路径
     */
    @Value("${adminPath}")
    protected String adminPath;

    /**
     * 前端基础路径
     */
    @Value("${frontPath}")
    protected String frontPath;

    protected Result success() {
        return new Result<>();
    }

    protected Result success(IPage page) {
        Map<String, Object> data = Maps.newHashMap();
        data.put("total", page.getTotal());
        data.put("list", page.getRecords());
        return new Result<>(data);
    }

    protected <T> Result<T> success(T data) {
        return new Result<>(data);
    }

    protected <T> Result<T> error() {
        return new Result<>(ErrorCode.INTERNAL_SERVER_ERROR, null);
    }

    protected Result error(ErrorCode code) {
        return new Result<>(code, null);
    }

    protected <T> Result<T> error(ErrorCode code, T data) {
        return new Result<>(code, data);
    }

}
