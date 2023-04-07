package parvez.alam.observability.service.impl;

import io.micrometer.observation.Observation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import parvez.alam.observability.exception.ServiceException;
import parvez.alam.observability.service.AppService;

import java.time.LocalDateTime;
import java.util.Random;

@Service
public class AppServiceImpl implements AppService {

    @Autowired
    private Observation appObservation;
    private static final Random RANDOM = new Random();

    @Override
    public String getCurrentYearWithoutObservability() {

        try {
            if (RANDOM.nextBoolean()) {
                throw new ServiceException("Error Occurred");
            }
        }
        catch (ServiceException e)
        {
            e.printStackTrace();
        }
        return Integer.toString(LocalDateTime.now().getYear());
    }

    @Override
    public String getCurrentYearWithObservability() throws ServiceException {
        appObservation.start();
        int year = 0;
        try (Observation.Scope scope = appObservation.openScope()) {
            if (RANDOM.nextBoolean()) {
                throw new ServiceException("Error while getting year");
            }
            year = LocalDateTime.now().getYear();
            appObservation.event(Observation.Event.of("Current YEAR: " + year));
        }
        catch (ServiceException e) {
            appObservation.error(e);
//            throw new ServiceException(ServiceException.getMessage());
        }
        finally {
            appObservation.stop();
        }
        return Integer.toString(year);
    }
}
