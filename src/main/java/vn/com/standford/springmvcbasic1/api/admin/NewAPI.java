package vn.com.standford.springmvcbasic1.api.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vn.com.standford.springmvcbasic1.dto.NewDTO;
import vn.com.standford.springmvcbasic1.service.INewService;

@RestController(value = "newAPIOfAdmin")
public class NewAPI {
    @Autowired
    private INewService newService;
    @PostMapping("/api/new")
    public NewDTO createNew(@RequestBody NewDTO newDTO){
        return  newService.save(newDTO);
    }
    @PutMapping("/api/new")
    public NewDTO updateNew(@RequestBody NewDTO newDTO){
        return  newService.save(newDTO);
    }
    @DeleteMapping("/api/new")
    public void deleteNew(@RequestBody Long[] ids){

        newService.delete(ids);
    }

}
