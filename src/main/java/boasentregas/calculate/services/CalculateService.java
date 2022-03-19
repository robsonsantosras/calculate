package boasentregas.calculate.services;

import boasentregas.calculate.models.Addresses;
import boasentregas.calculate.models.Distance;

public interface CalculateService {
    Distance Distance(Addresses addresses);
}
