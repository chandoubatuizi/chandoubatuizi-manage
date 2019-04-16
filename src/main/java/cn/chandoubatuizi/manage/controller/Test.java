package cn.chandoubatuizi.manage.controller;


import cn.chandoubatuizi.manage.common.exception.ServiceException;
import cn.chandoubatuizi.manage.common.responseWrap.JsonResponse;
import cn.chandoubatuizi.manage.dao.CountryPriceDOMapper;
import cn.chandoubatuizi.manage.model.CountryPriceDO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("test")
public class Test {

    private final Logger logger = LoggerFactory.getLogger(Test.class);

    @Autowired
    private CountryPriceDOMapper countryPriceDOMapper;

    @RequestMapping("test1")
    @ResponseBody
    public CountryPriceDO select() {
        CountryPriceDO countryPriceDO = countryPriceDOMapper.selectByPrimaryKey(1);
        return countryPriceDO;
    }

    @RequestMapping("test2")
    @ResponseBody
    public void test() {
        logger.debug("================debug=============");
        logger.info("================info=============");
        logger.warn("================warn=============");
        logger.error("================error=============");
    }

    @RequestMapping("test3")
    @JsonResponse
    public CountryPriceDO select2() throws ServiceException {
        CountryPriceDO countryPriceDO = countryPriceDOMapper.selectByPrimaryKey(1);
        if (countryPriceDO != null) {
            throw new ServiceException(1, "test");
        }
        return countryPriceDO;
    }

    @RequestMapping("test4")
    @JsonResponse
    public void test4() {
        int i = 1 / 0;

    }
}
