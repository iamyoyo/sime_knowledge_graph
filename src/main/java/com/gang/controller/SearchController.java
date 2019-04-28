package com.gang.controller;

//import com.alibaba.fastjson.JSONArray;
import com.gang.dao.impl.KnowledgeMongoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import org.json.JSONArray;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import com.gang.entity.knowledge;

/**
 * Created by 吕港 on 2018/2/11.
 */
@Controller
@RequestMapping("/search/")
public class SearchController {
    @Autowired
    private KnowledgeMongoImpl knowledgeMongo;

    @RequestMapping(value = "findSomething.do", method = RequestMethod.POST)
    public void findSomething(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        List<knowledge> judge = knowledgeMongo.findForRequery(request.getParameter("titleName"));
        JSONArray something=new JSONArray(judge);
        out.print(something);
        out.flush();
    }
}
