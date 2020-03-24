package com.version.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author version
 * @version 1.0
 * @date 2020/3/21 15:44
 */
@Controller
public class Indexcontroller {
    @GetMapping("/{id}/{name}")
    public String index(@PathVariable Integer id,@PathVariable String name){
        System.out.println("----------wen----------");
        return "index";
    }
}
