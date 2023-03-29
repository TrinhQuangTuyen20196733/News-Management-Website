package vn.com.standford.springmvcbasic1.service;

import org.springframework.stereotype.Service;

import java.util.List;
public interface HomeService {
    List<String> loadMenu();
}
