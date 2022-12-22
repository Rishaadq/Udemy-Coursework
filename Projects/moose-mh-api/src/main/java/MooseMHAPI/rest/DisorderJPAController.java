package MooseMHAPI.rest;

import MooseMHAPI.disorder.Disorder;
import MooseMHAPI.disorder.Symptom;
import MooseMHAPI.exception.DisorderNotFoundException;
import MooseMHAPI.jpa.DisorderRepository;
import MooseMHAPI.jpa.SymptomRepository;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.DependsOn;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController("disorderJPAController")
@DependsOn("initDB")
@Slf4j
public class DisorderJPAController {

    private final DisorderRepository disorderRepository;
    private final SymptomRepository symptomRepository;

    @Autowired
    public DisorderJPAController(DisorderRepository disorderRepository, SymptomRepository symptomRepository) {
        this.disorderRepository = disorderRepository;
        this.symptomRepository = symptomRepository;
    }



    @GetMapping("/jpa/disorders")
    public List<Disorder> retrieveAllDisorders() {
        return disorderRepository.findAll();
    }

    @GetMapping("/jpa/test")
    public String test() {
        return "Idiot!";
    }

    @DeleteMapping("/jpa/disorders")
    public void deleteAllDisorders() {
        disorderRepository.deleteAll();
    }

    @DeleteMapping("/jpa/disorders/{id}")
    public void deleteDisorderById(@PathVariable int id) {
        disorderRepository.deleteById(id);
    }

    @GetMapping("/jpa/disorders/{id}")
    public Optional<Disorder> getDisorderById(@PathVariable int id) {
        Optional<Disorder> addedDisorder = disorderRepository.findById(id);
        if(addedDisorder.isEmpty()) {
            throw new DisorderNotFoundException("Disorder with id: " + id + "not found :(");
        }
        return addedDisorder;
    }

    @PostMapping("/jpa/disorders/{id}/symptoms")
    public ResponseEntity<Object> addSymptomToDisorder (@PathVariable int id, @RequestBody Symptom symptom) {
        Optional<Disorder> disorder = disorderRepository.findById(id);

        if (disorder.isEmpty())
            throw new DisorderNotFoundException("id:" + id);

        symptom.setDisorder(disorder.get());

        Symptom savedSymptom = symptomRepository.save(symptom);
        log.info("SYMPTOM SAVED!: " +savedSymptom);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedSymptom.getId()).toUri();

        return ResponseEntity.created(location).build();
    }
}
