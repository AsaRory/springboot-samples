package cn.chenzw.springboot.mybatis.xml.repository;

import cn.chenzw.springboot.mybatis.xml.MybatisXmlApp;
import cn.chenzw.springboot.mybatis.xml.domain.entity.JavaTypesEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {MybatisXmlApp.class})
@WebAppConfiguration
public class JavaTypesMapperTests {

    @Autowired
    JavaTypesMapper typesMapper;

    @Test
    public void testListAll(){
        List<JavaTypesEntity> typesEntiys = typesMapper.listAll();
        System.out.println(typesEntiys);

    }

}