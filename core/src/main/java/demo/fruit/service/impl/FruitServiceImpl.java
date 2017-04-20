package demo.fruit.service.impl;

import com.github.pagehelper.PageHelper;
import com.hand.hap.core.IRequest;
import com.hand.hap.system.dto.DTOStatus;
import com.hand.hap.system.service.impl.BaseServiceImpl;
import demo.fruit.mapper.FruitMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import demo.fruit.dto.Fruit;
import demo.fruit.service.IFruitService;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class FruitServiceImpl extends BaseServiceImpl<Fruit> implements IFruitService{

    @Autowired
    private FruitMapper fruitMapper;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, rollbackFor =
            Exception.class)
    public List<Fruit> selectByFruit(IRequest requestContext, Fruit fruit, int
            page, int pagesize) {
        PageHelper.startPage(page, pagesize);
        return fruitMapper.selectByFruit(fruit);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Fruit> batchUpdate(IRequest requestContext, List<Fruit> fruits){
        for (Fruit fruit : fruits) {
            if (fruit.get__status() != null) {
                switch (fruit.get__status()) {
                    case DTOStatus.ADD:
                        fruitMapper.insertFruit(fruit);
                        break;
                    case DTOStatus.UPDATE:
                        fruitMapper.updateFruit(fruit);
                        break;
                    default:
                        break;
                }
            }
        }
        return fruits;
    }
}