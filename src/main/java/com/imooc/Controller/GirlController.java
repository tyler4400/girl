package com.imooc.Controller;

import com.imooc.domain.Girl;
import com.imooc.repository.GirlRepository;
import com.imooc.service.GirlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * create by tyler on 2019/2/2 8:45,
 * reach me by tyler4400@foxmail.com
 */
@RestController
public class GirlController {

    @Autowired
    private GirlRepository girlRepository;

    @Autowired
    private GirlService girlService;


    /**
     * 查询所有女生列表
     * @return
     */
    @GetMapping(value = "/girls")
    public List<Girl> girlList(){
        return girlRepository.findAll();
    }

    /**
     * 添加\更新一个女生
     * @return
     */
    @PostMapping(value = "/addGirl")
    public Girl girlAdd(@Valid Girl girl, BindingResult br){
        if(br.hasErrors()) System.out.println(Objects.requireNonNull(br.getFieldError()).getDefaultMessage());
        return this.girlRepository.save(girl);

    }

    /**
     * 删除一个女生
     * @return
     */
    @PostMapping(value = "/deleteGirl")
    public String girlDelete(@RequestParam("id") Integer id){
        this.girlRepository.deleteById(id);
        return "删除成功";

    }

    /**
     * 查找一个女生
     * @param id
     * @return
     */
    @GetMapping(value = "/findGirl")
    public Girl girlFindOne(@RequestParam("id") Integer id){
        Optional<Girl> girlOptional = this.girlRepository.findById(id);
//        return girlOptional.isPresent() ?  girlOptional.get() :  null;
        return girlOptional.orElse(null);

    }

    @PostMapping(value = "/girls/two")
    public void girlTwo() {
        girlService.insertTwo();
    }
}
