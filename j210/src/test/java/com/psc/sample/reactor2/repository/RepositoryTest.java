package com.psc.sample.reactor2.repository;

import com.psc.sample.reactor2.domain.Item;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import reactor.test.StepVerifier;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataMongoTest
public class RepositoryTest {

    @Autowired
    ItemReactiveRepository itemReactiveRepository;

    @Autowired
    CartReactiveRepository cartReactiveRepository;

    public Long itemCnt;

    @BeforeEach
    void setUp(){
        StepVerifier.create(
                itemReactiveRepository.deleteAll()
        ).verifyComplete();

        Item item1 = new Item("lego", "made in usa", 20.00);
        Item item2 = new Item("lego", "made in china", 10.00);
        Item item3 = new Item("rc car", "made in usa", 40.00);
        Item item4 = new Item("rc car", "made in china", 20.00);
        Item item5 = new Item("rc car", "made in india", 15.00);
        Item item6 = new Item("drone", "made in korea", 100.00);
        List<Item> itemList = Arrays.asList(item1,item2,item3,item4,item5,item6);

        itemCnt = Long.valueOf(itemList.size());
        StepVerifier.create(
                itemReactiveRepository.saveAll(itemList)
        ).expectNextMatches(item -> {
            System.out.println(item.toString());
            return true;
        }).expectNextCount(itemCnt - 1).verifyComplete();
    }


    @Test
    public void itemRepositoryCount(){
        StepVerifier.create(
                itemReactiveRepository.findAll().count()
        ).expectNextMatches(cnt ->{
            assertThat(cnt).isEqualTo(itemCnt);
            return true;
        }).verifyComplete();
    }

    @Test
    public void itemRepositoryCount2(){
        StepVerifier.create(
                itemReactiveRepository.findByNameContaining("rc").count()
        ).expectNextMatches(cnt ->{
            assertThat(cnt).isEqualTo(3);
            return true;
        }).verifyComplete();
    }

    @Test
    public void itemSearchName2(){
        StepVerifier.create(
                itemReactiveRepository.findByName("drone")
        ).expectNextMatches(item ->{
            assertThat(item.getId()).isNotNull();
            assertThat(item.getName()).isEqualTo("drone");
            assertThat(item.getDescription()).isEqualTo("made in korea");
            assertThat(item.getPrice()).isEqualTo(100.00);
            return true;
        }).verifyComplete();
    }


    @Test
    public void itemSearchName(){
        StepVerifier.create(
                itemReactiveRepository.findByNameContaining("rc")
        ).expectNextMatches(item -> {
            System.out.println(item.toString());
            return true;
        }).expectNextCount(2).verifyComplete();
    }
}
