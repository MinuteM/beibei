package org.camunda.bpm.getstarted.loanapprovalspringboot.oauth.domain.bean;

import lombok.Data;

@Data
public class RefreshTokenBean {

    /**
     * 过期时间
     */
    private String expiration;
    /**
     * token值
     */
    private String value;

}
