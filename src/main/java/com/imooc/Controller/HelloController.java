package com.imooc.Controller;

import com.imooc.properties.GirlProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * create by tyler on 2019/2/1 11:01,
 * reach me by tyler4400@foxmail.com
 */
@RestController
public class HelloController {
    @Value("${cupSize}")
    private String cupSize;

    @Autowired
    private GirlProperties girlProperties;

    @RequestMapping(value = {"/hello", "/hi"}, method = RequestMethod.GET)
    public String say(){
        return this.girlProperties.toString() + " | " + this.cupSize;
    }

    @RequestMapping(value = "/getid/{id}", method = RequestMethod.GET)
    public String getId(@PathVariable Integer id){
        return "id: " + id;
    }

//    @RequestMapping(value = "/getsomething", method = RequestMethod.GET)
    @GetMapping(value = "/getsomething")
    public String getId(@RequestParam(value = "id", required = false, defaultValue = "0") Integer id, @RequestParam String name){
        return "id: " + id + ", name: " + name;
    }
}
