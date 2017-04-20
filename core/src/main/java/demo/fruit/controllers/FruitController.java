package demo.fruit.controllers;

import org.springframework.stereotype.Controller;
import com.hand.hap.system.controllers.BaseController;
import com.hand.hap.core.IRequest;
import com.hand.hap.system.dto.ResponseData;
import demo.fruit.dto.Fruit;
import demo.fruit.service.IFruitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

    @Controller
    public class FruitController extends BaseController{

    @Autowired
    private IFruitService service;


    @RequestMapping(value = "/fruit/query")
    @ResponseBody
    public ResponseData query(Fruit dto, @RequestParam(defaultValue = DEFAULT_PAGE) int page,
        @RequestParam(defaultValue = DEFAULT_PAGE_SIZE) int pageSize, HttpServletRequest request) {
        IRequest requestContext = createRequestContext(request);
        return new ResponseData(service.select(requestContext,dto,page,pageSize));
    }

    @RequestMapping(value = "/fruit/submit")
    @ResponseBody
    public ResponseData update(HttpServletRequest request,@RequestBody List<Fruit> dto){
        IRequest requestCtx = createRequestContext(request);
        return new ResponseData(service.batchUpdate(requestCtx, dto));
    }

    @RequestMapping(value = "/fruit/remove")
    @ResponseBody
    public ResponseData delete(HttpServletRequest request,@RequestBody List<Fruit> dto){
        service.batchDelete(dto);
        return new ResponseData();
    }
    }