package vn.com.standford.springmvcbasic1.util;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class Messageutil {
public Map<String,String> getMessage(String message){
    Map<String,String> result = new HashMap<>();
    if (message != null) {
        switch (message) {
            case "create_success":
                result.put("message", "Create Success");
                result.put("alert", "success");
                break;
            case "update_success":
                result.put("message", "Update Success");
                result.put("alert", "success");
                break;
            case "delete_success":
                result.put("message","Delete Success");
                result.put("alert","success");
                break;
            case "error_system":
                result.put("message", "Error System");
                result.put("alert", "danger");
                break;

        }
    }
    return result;
}

}
