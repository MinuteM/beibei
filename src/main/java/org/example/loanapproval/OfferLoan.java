package org.example.loanapproval;

import cn.hutool.core.util.RandomUtil;
import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class OfferLoan implements JavaDelegate {

    @Override
    public void execute(DelegateExecution delegateExecution) {
        // 生成随机数
        int random = RandomUtil.randomInt(20);
        delegateExecution.setVariable("随机数", random);
        log.info("随机数：" + random);
    }
}
