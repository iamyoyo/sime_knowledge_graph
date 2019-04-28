package com.gang.dao;

/**
 * Created by 吕港 on 2018/2/11.
 */
import com.gang.entity.knowledge;

import java.util.List;


public interface KnowledgeMongoDao {
    List<knowledge> findAll();
    void insertPerson(knowledge user);
    void removePerson(String userName);
    void updatePerson();
    List<knowledge> findForRequery(String titleName);
}
