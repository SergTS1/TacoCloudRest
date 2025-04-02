package sia.tacocloud.service.kafka;

import sia.tacocloud.domain.entyty.TacoOrder;

public interface OrderMessagingService {

    void sendOrder(TacoOrder order);
}
