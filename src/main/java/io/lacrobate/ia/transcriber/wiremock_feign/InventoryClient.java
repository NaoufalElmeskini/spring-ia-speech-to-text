package io.lacrobate.ia.transcriber.wiremock_feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

//fixme: delete this after you understand wiremock
@FeignClient(value = "inventory-service", url = "${inventory.url}")
public interface InventoryClient {
	@RequestMapping(method = RequestMethod.GET, value = "/api/inventory")
	boolean isInStock(@RequestParam String skuCode, @RequestParam Integer quantity);
}
