package com.atguigu.gamll.index.controller;

import com.atguigu.core.bean.Resp;
import com.atguigu.gamll.index.service.IndexService;
import com.atguigu.gmall.pms.entity.CategoryEntity;
import com.atguigu.gmall.pms.vo.CategoryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("index")
public class IndexController {

    @Autowired
    private IndexService indexService;

    @GetMapping("cates")
    public Resp<List<CategoryEntity>> queryLvl1Categories(){

        List<CategoryEntity> categoryEntities = indexService.queryLvl1Categories();
        return Resp.ok(categoryEntities);
    }

    @GetMapping("cates/{pid}")
    public Resp<List<CategoryVo>> queryCategoriesWithSub(@PathVariable("pid") Long pid){
        List<CategoryVo> categoryVos = indexService.queryCategoriesWithSub(pid);
        return Resp.ok(categoryVos);
    }

    @GetMapping("test/lock")
    public Resp<Object> lock(){
        indexService.testLock();
        return Resp.ok(null);
    }


    @GetMapping("read")
    public Resp<String> read(){
        String msg = indexService.testRead();
        return Resp.ok(msg);
    }


    @GetMapping("write")
    public Resp<String> write(){
        String msg = indexService.testwrite();
        return Resp.ok(msg);
    }

    @GetMapping("door")
    public Resp<String> door(){
        String msg = indexService.door();
        return Resp.ok(msg);
    }


    @GetMapping("down")
    public Resp<String> down(){
        String msg = indexService.down();
        return Resp.ok(msg);
    }
}
