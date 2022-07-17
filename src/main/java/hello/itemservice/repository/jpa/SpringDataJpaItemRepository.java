package hello.itemservice.repository.jpa;

import hello.itemservice.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

//스프링 데이터 jpa를 사용하기 위해서 JpaRepository를 상속받는다.
//제네릭에 관리할 entity와 entity의 pk 타입을 지정해준다.
public interface SpringDataJpaItemRepository extends JpaRepository<Item, Long> {


    //아이템의 이름으로 아이템을 찾아오는 메서드
    List<Item> findByItemNameLike(String itemName);

    //아이템의 가격으로 찾아오기
    List<Item> findByPriceLessThanEqual(Integer price);

    //쿼리 메서드 사용해보기
    //쿼리메서드를 사용할 때 조건이 두개 이상 넘어가면 상당히 복잡한 것을 확인할 수 있다
    List<Item> findByItemNameLikeAndPriceLessThanEqual(String itemName, Integer price);


    //쿼리를 직접 실행해보기
    @Query("select i from Item i where i.itemName like :itemName and i.price <= :price")
    List<Item> findItems(@Param("itemName") String itemName, @Param("price")Integer price);

}
