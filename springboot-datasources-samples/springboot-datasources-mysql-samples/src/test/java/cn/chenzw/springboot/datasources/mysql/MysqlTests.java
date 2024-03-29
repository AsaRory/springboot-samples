package cn.chenzw.springboot.datasources.mysql;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.sql.DataSource;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = MysqlSamplesApp.class)
@WebAppConfiguration
public class MysqlTests {


    @Autowired
    DataSource dataSource;

    @Test
    public void testDataSource() {
        Assert.assertNotNull(dataSource);
    }
}
