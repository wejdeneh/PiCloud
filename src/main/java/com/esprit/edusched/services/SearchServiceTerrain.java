package com.esprit.edusched.services;

import com.esprit.edusched.entities.Terrain;
import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.Search;
import org.hibernate.search.query.dsl.BooleanJunction;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;


import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class SearchServiceTerrain implements ApplicationListener<ContextRefreshedEvent> {

    @Transactional
    public void fullIndexation(){
        final FullTextEntityManager fullTextEntityManager = Search.getFullTextEntityManager(entityManager);
        try {
            fullTextEntityManager.createIndexer().startAndWait();
        } catch (InterruptedException e) {
            // Handle interruption exception
            Thread.currentThread().interrupt();
        }
    }
    @Autowired
    private SearchServiceTerrain searchServiceTerrain;
    @Autowired
    private EntityManager entityManager;
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        searchServiceTerrain.fullIndexation();

    }
    public String fieldContainsFormat(String input) {
        return "*" + input + "*";
    }
    public List<Terrain> findTerrainByName(String name) {
        final FullTextEntityManager fullTextEntityManager
                = Search.getFullTextEntityManager(entityManager);

        final QueryBuilder queryBuilder = fullTextEntityManager.getSearchFactory()
                .buildQueryBuilder()
                .forEntity(Order.class)
                .get();

        final BooleanJunction<?> boolJunction = queryBuilder.bool();
        if (StringUtils.hasLength(name)) {
            org.apache.lucene.search.Query orderIdQuery = queryBuilder
                    .keyword()
                    .wildcard()
                    .onField("name")
                    .matching(this.fieldContainsFormat(name))
                    .createQuery();
            boolJunction.must(orderIdQuery);
        }

        org.hibernate.search.jpa.FullTextQuery jpaQuery
                = fullTextEntityManager.createFullTextQuery(boolJunction.createQuery(), Terrain.class);
        return(List<Terrain>) jpaQuery.getResultList();
    }



}
