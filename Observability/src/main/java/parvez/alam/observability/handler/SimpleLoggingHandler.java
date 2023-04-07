package parvez.alam.observability.handler;

import io.micrometer.observation.Observation;
import io.micrometer.observation.ObservationHandler;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SimpleLoggingHandler implements ObservationHandler<Observation.Context> {
    @Override
    public void onStart(Observation.Context context) {
        log.info("START -> context Name : {}", context.getName());
    }

    @Override
    public void onStop(Observation.Context context) {
        log.info("STOP  -> context Name : {}", context.getName());
    }

    @Override
    public void onScopeOpened(Observation.Context context) {
        log.info("ScopeOpened -> context Name : {}", context.getName());
    }

    @Override
    public void onScopeClosed(Observation.Context context) {
        log.info("ScopeClosed -> context Name : {}", context.getName());
    }

    @Override
    public void onError(Observation.Context context) {

        var error = context.getError();
        var message = error != null ? error.getMessage() : null ;

        log.info("Error Occurred -> context Name : {} , ; Error : {}", context.getName(), message);
    }

    @Override
    public void onEvent(Observation.Event event, Observation.Context context) {
        log.info("EVENT -> Context Name : {}   ;  Event Name : {}", context.getName(), event.getName());
    }

    @Override
    public boolean supportsContext(Observation.Context context) {
        return true;
    }
}