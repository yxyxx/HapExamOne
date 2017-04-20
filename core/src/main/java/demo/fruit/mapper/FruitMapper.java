package demo.fruit.mapper;

import com.hand.hap.mybatis.common.Mapper;
import demo.fruit.dto.Fruit;

import java.util.List;

public interface FruitMapper extends Mapper<Fruit>{

    List<Fruit> selectByFruit(Fruit fruit);
    int insertFruit(Fruit fruit);
    int updateFruit(Fruit fruit);
    int deleteFruit(Fruit fruit);
}