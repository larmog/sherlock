package sherlock.hysterix;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Map;

public interface UserClient {
    @RequestMapping(method = RequestMethod.GET, value = "/users")
    List<Map> getUsers();
}
