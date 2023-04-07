package parvez.alam.observability.service;

import parvez.alam.observability.exception.ServiceException;

public interface AppService {

    String getCurrentYearWithoutObservability();

    String getCurrentYearWithObservability() throws ServiceException;
}
