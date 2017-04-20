package demo.fruit.service;

import com.hand.hap.core.IRequest;
import com.hand.hap.core.ProxySelf;
import com.hand.hap.core.annotation.StdWho;
import com.hand.hap.system.service.IBaseService;
import demo.fruit.dto.Fruit;

import java.util.List;

public interface IFruitService extends IBaseService<Fruit>, ProxySelf<IFruitService>{
    List<Fruit> selectByFruit(IRequest requestContext, Fruit fruit, int page, int
            pagesize);

    List<Fruit> batchUpdate(IRequest requestContext, @StdWho List<Fruit>
            fruits);
}