package parvez.alam.observability.service.impl;

import org.springframework.stereotype.Service;
import parvez.alam.observability.exception.ServiceException;
import parvez.alam.observability.service.AppService;

import java.time.LocalDateTime;
import java.util.Random;

@Service
public class AppServiceImpl implements AppService {

    private static final Random RANDOM = new Random();

    @Override
    public Integer getCurrentYear() {

        try {
            if (RANDOM.nextBoolean()) {
                throw new ServiceException("Error Occurred");
            }
        }
        catch (ServiceException e)
        {
            e.printStackTrace();
        }
        return LocalDateTime.now().getYear();
    }
}
