package boasentregas.calculate.services.impl;

import boasentregas.calculate.models.Addresses;
import boasentregas.calculate.models.Distance;
import boasentregas.calculate.models.google.Root;
import boasentregas.calculate.services.CalculateService;
import boasentregas.security.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class CalculateServiceImpl implements CalculateService {


    @Autowired
    private RestTemplate restTemplate;


    public Distance Distance(Addresses addresses) {
        String key = "AIzaSyDhBzLQ7ZxmERoSZcMxO0H7sjizGSu9QSA";

        String url = "https://maps.googleapis.com/maps/api/directions/json?" +
                String.format("origin=%s&destination=%s&key=%s",addresses.getOrigin().toString(),addresses.getDestination().toString(),key);


        Root root = restTemplate.getForObject(url, Root.class);

        Distance distance = new Distance();

        distance.setDistance(root.routes.get(0).legs.get(0).distance.value / 1000);
        distance.setDuration((root.routes.get(0).legs.get(0).duration.value / 3600));

        return distance;

    }
}
