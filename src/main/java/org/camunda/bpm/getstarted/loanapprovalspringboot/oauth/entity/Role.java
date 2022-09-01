package org.camunda.bpm.getstarted.loanapprovalspringboot.oauth.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;
import org.camunda.bpm.getstarted.loanapprovalspringboot.oauth.domain.Base;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "um_t_role")
public class Role extends Base implements Serializable {

    private static final long serialVersionUID = -8478114427891717226L;

    /**
     * 角色名
     */
    private String name;

    /**
     * 角色
     */
    private String role;

    /**
     * 角色 -- 用户: 1对多
     */
    @JsonBackReference
    @OneToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "um_t_role_user", joinColumns = {@JoinColumn(name = "roleId")}, inverseJoinColumns = {@JoinColumn(name = "userId")})
    private Set<User> users;
}
