package com.gang.dao.impl;

/**
 * Created by 吕港 on 2018/2/11.
 */

import com.gang.dao.KnowledgeMongoDao;
import com.gang.entity.knowledge;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("knowledgeMongo")
public class KnowledgeMongoImpl implements KnowledgeMongoDao {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public List<knowledge> findAll() {
        return mongoTemplate.findAll(knowledge.class, "Trigrams");
    }

    @Override
    public void insertPerson(knowledge user) {
        mongoTemplate.insert(user, "Trigrams");
    }

    @Override
    public void removePerson(String userName) {
        mongoTemplate.remove(Query.query(Criteria.where("title").is(userName)), "Trigrams");
    }

    @Override
    public void updatePerson() {
        mongoTemplate.updateMulti(Query.query(Criteria.where("age").gt(3).lte(5)), Update.update("age", 3), "Trigrams");
    }

    @Override
    public List<knowledge> findForRequery(String titleName) {
        return mongoTemplate.find(Query.query(Criteria.where("title").regex(titleName)), knowledge.class, "Trigrams");
    }
}
