package org.camunda.bpm.getstarted.loanapprovalspringboot.oauth.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.camunda.bpm.getstarted.loanapprovalspringboot.oauth.domain.Base;


/**
 * @description 用户返回参数对象
 * @author Zhifeng.Zeng
 * @date 2019/3/7
 */
@Setter
@Getter
@ToString
public class UserVO extends Base {

    /**
     * 用户账号
     */
    private String account;

    /**
     * 用户名
     */
    private String name;

    /**
     * 用户密码
     */
    private String password;

    /**
     * 用户角色
     */
    private RoleVO role;


}
