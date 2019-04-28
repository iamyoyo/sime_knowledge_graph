/**
 * Created by 吕港 on 2018/2/11.
 */
import com.gang.dao.impl.KnowledgeMongoImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring配置文件
@ContextConfiguration({"classpath:applicationContext.xml", "classpath:mongodb-context.xml"})
public class KnowledgeTest {
    @Resource
    private KnowledgeMongoImpl knowledgeMongo;

    @Test
    public void testMongoTemplate() {
        //模拟测试
        System.out.println(knowledgeMongo.findAll());
        System.out.println(knowledgeMongo.findForRequery("雁荡山"));
    }
}
