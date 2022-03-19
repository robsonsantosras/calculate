package boasentregas.calculate.controllers;

import boasentregas.calculate.models.Addresses;
import boasentregas.calculate.models.Distance;
import boasentregas.calculate.services.CalculateService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@AllArgsConstructor
@RestController
@RequestMapping("calculate/v1")
public class CalculateController {

    private final CalculateService calculateService;

    @PostMapping ("/distance")
    public ResponseEntity<Distance> Post(@RequestBody Addresses addresses)
    {
        Distance distance = calculateService.Distance(addresses);

        return new ResponseEntity<Distance>(distance, HttpStatus.CREATED);
    }
}
