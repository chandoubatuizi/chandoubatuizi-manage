package cn.chandoubatuizi.manage.core.service;

import cn.chandoubatuizi.manage.common.exception.ServiceException;
import cn.chandoubatuizi.manage.model.UserDO;

public interface TestService {

    int create() throws ServiceException;

    UserDO select();

}
