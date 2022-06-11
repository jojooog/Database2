package hello.itemservice.repository.mybatis;


import hello.itemservice.domain.Item;
import hello.itemservice.repository.ItemSearchCond;
import hello.itemservice.repository.ItemUpdateDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;

@Mapper
public interface ItemMapper {

    void save(Item item);

    //parameter가 하나인 경우에는 Param 어노테이션 생략 가능
    void update(@Param("id") Long id, @Param("updateParam")ItemUpdateDto updateParam);


    Optional<Item> findById(Long id);

    List<Item> findAll(ItemSearchCond itemSearch);




}
