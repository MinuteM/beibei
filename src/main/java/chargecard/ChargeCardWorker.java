package chargecard;

//import org.camunda.bpm.client.ExternalTaskClient;

import java.util.logging.Logger;

public class ChargeCardWorker {

    private final static Logger LOGGER = Logger.getLogger(ChargeCardWorker.class.getName());

//    public static void main(String[] args) {
//        ExternalTaskClient client = ExternalTaskClient.create().baseUrl("http://localhost:8080/engine-rest")
//                .asyncResponseTimeout(10000).build();
//
//        client.subscribe("charge-card").lockDuration(1000).handler((externalTask, externalTaskService) -> {
//            String item = externalTask.getVariable("item");
//            Long amount = externalTask.getVariable("amount");
//            LOGGER.info("Charging credit card with an amount of " + amount + "'$ for the item " + item + "'...");
//            externalTaskService.complete(externalTask);
//        }).open();
//    }
}
