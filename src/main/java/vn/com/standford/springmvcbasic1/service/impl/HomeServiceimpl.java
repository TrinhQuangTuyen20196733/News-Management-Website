package vn.com.standford.springmvcbasic1.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.com.standford.springmvcbasic1.service.HomeService;

import java.util.ArrayList;
import java.util.List;

@Service
public class HomeServiceimpl implements HomeService {


    public List<String> loadMenu() {
        List<String> menuList = new ArrayList<String>();
        menuList.add("Blog Java");
        menuList.add("Hướng dẫn học JavaWeb");
        menuList.add("Liên hệ");
        menuList.add("Thanh toán");
        return menuList;
    }
}
