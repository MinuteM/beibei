package org.camunda.bpm.getstarted.loanapprovalspringboot.oauth.controller;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.getstarted.loanapprovalspringboot.oauth.dto.LoginUserDTO;
import org.camunda.bpm.getstarted.loanapprovalspringboot.oauth.dto.UserDTO;
import org.camunda.bpm.getstarted.loanapprovalspringboot.oauth.service.RoleService;
import org.camunda.bpm.getstarted.loanapprovalspringboot.oauth.service.UserService;
import org.camunda.bpm.getstarted.loanapprovalspringboot.oauth.utils.AssertUtils;
import org.camunda.bpm.getstarted.loanapprovalspringboot.oauth.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @description 用户权限管理
 * @author Zhifeng.Zeng
 * @date 2019/4/19 13:58
 */
@Slf4j
@Validated
@RestController
@RequestMapping("/auth/")
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private RedisTokenStore redisTokenStore;

    /**
     * @description 添加用户
     * @param userDTO
     * @return
     */
    @PostMapping("user")
    public ResponseVO add(@Valid @RequestBody UserDTO userDTO) throws Exception {
        userService.addUser(userDTO);
        return ResponseVO.success();
    }

    /**
     * @description 删除用户
     * @param id
     * @return
     */
    @DeleteMapping("user/{id}")
    public ResponseVO deleteUser(@PathVariable("id")Integer id) throws Exception {
        userService.deleteUser(id);
        return ResponseVO.success();
    }

    /**
     * @descripiton 修改用户
     * @param userDTO
     * @return
     */
    @PutMapping("user")
    public ResponseVO updateUser(@Valid @RequestBody UserDTO userDTO){
        userService.updateUser(userDTO);
        return ResponseVO.success();
    }

    /**
     * @description 获取用户列表
     * @return
     */
    @GetMapping("user")
    public ResponseVO findAllUser(){
        return userService.findAllUserVO();
    }

    /**
     * @description 用户登录
     * @param loginUserDTO
     * @return
     */
    @PostMapping("user/login")
    public ResponseVO login(LoginUserDTO loginUserDTO){
        return userService.login(loginUserDTO);
    }


    /**
     * @description 用户注销
     * @param authorization
     * @return
     */
    @GetMapping("user/logout")
    public ResponseVO logout(@RequestHeader("Authorization") String authorization){
        redisTokenStore.removeAccessToken(AssertUtils.extracteToken(authorization));
        return ResponseVO.success();
    }

    /**
     * @description 获取所有角色列表
     * @return
     */
    @GetMapping("role")
    public ResponseVO findAllRole(){
        return roleService.findAllRoleVO();
    }


}