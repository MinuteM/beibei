package org.camunda.bpm.getstarted.loanapprovalspringboot.oauth.service;


import org.camunda.bpm.getstarted.loanapprovalspringboot.oauth.entity.Role;
import org.camunda.bpm.getstarted.loanapprovalspringboot.oauth.vo.ResponseVO;

/**
 * @description 角色管理接口
 * @author Zhifeng.Zeng
 * @date 2019/2/21 11:05
 */
public interface RoleService {

    /**
     * @description 获取角色列表
     * @return
     */
    ResponseVO findAllRoleVO();

    /**
     * @description 根据角色id获取角色
     */
    Role findById(Integer id);
}
