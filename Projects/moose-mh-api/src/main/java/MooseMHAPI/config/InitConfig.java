package MooseMHAPI.config;

import lombok.extern.slf4j.Slf4j;
import MooseMHAPI.disorder.Disorder;
import MooseMHAPI.disorder.Symptom;
import MooseMHAPI.jpa.DisorderRepository;
import MooseMHAPI.jpa.SymptomRepository;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class InitConfig {

    private final DisorderRepository disorderRepository;
    private final SymptomRepository symptomRepository;


    @Autowired
    public InitConfig(DisorderRepository disorderRepository, SymptomRepository symptomRepository) {
        this.disorderRepository = disorderRepository;
        this.symptomRepository = symptomRepository;
    }

    @Bean("initDB")
    public void initializeDatabase() {
        log.info("DISORDER REPO EMPTY??: " + disorderRepository.findAll().isEmpty());
        log.info("SYMPTOM REPO EMPTY??: " + symptomRepository.findAll().isEmpty());
        if (disorderRepository.findAll().isEmpty() && symptomRepository.findAll().isEmpty()) {
            disorderRepository.resetIncrementor(); /*resets the ID incrementor in the DB. everytime a new disorder is saved,
            the disorder_id will increase by one. */
            symptomRepository.resetIncrementor();
            List<Symptom> symptoms = new ArrayList<>();
            symptoms.add(new Symptom("Symptom 1", "Description 1"));
            symptoms.add(new Symptom("Symptom 2", "Description 2"));

            Disorder disorder = new Disorder(1, "Depression", "Description of depression", symptoms);
            for (Symptom symptom : symptoms) {
                symptom.setDisorder(disorder);
            }

            disorderRepository.save(disorder);

            disorderRepository.save(new Disorder(2, "Anxiety", "this is a description of what anxiety is.", new ArrayList<Symptom>()));
            disorderRepository.save(new Disorder(3, "Suicidal Ideation", "this is a description of what suicidal ideation is.", new ArrayList<Symptom>()));
        }
    }

}
