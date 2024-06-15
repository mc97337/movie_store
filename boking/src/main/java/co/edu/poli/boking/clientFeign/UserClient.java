package co.edu.poli.boking.clientFeign;

import co.edu.poli.commons.helper.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "user")
public interface UserClient {

    @GetMapping("api/poli/users/{id}")
    Response findById(@PathVariable("id") Long id);
}
