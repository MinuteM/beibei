package org.camunda.bpm.getstarted.loanapprovalspringboot.oauth.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;
import org.camunda.bpm.getstarted.loanapprovalspringboot.oauth.domain.Base;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "um_t_user")
public class User extends Base implements Serializable {
    private static final long serialVersionUID = -8478114427891717226L;

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
     * 用户 --角色 多对一
     */
    @JsonBackReference
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinTable(name = "um_t_role_user", joinColumns = {@JoinColumn(name = "userId")}, inverseJoinColumns = {@JoinColumn(name = "roleId")})
    private Role role;


}
