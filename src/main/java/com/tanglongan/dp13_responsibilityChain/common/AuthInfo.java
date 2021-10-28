package com.tanglongan.dp13_responsibilityChain.common;

import lombok.Getter;
import lombok.Setter;

/**
 * 责任链返回对象定义
 */
@Getter
@Setter
public class AuthInfo {

    private String code;
    private String info = "";

    public AuthInfo(String code, String... infos) {
        this.code = code;
        for (String str : infos) {
            this.info = this.info.concat(str);
        }
    }

}
