package org.camunda.bpm.getstarted.loanapprovalspringboot.oauth.repository;

import org.camunda.bpm.getstarted.loanapprovalspringboot.oauth.entity.User;
import org.camunda.bpm.getstarted.loanapprovalspringboot.oauth.repository.base.BaseRepository;

public interface UserRepository extends BaseRepository<User> {

    User findUserByAccount(String account);
}
