package MooseMHAPI.disorder;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import java.util.List;
import javax.persistence.OneToMany;

@Entity(name="disorders")
public class Disorder {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(nullable = false)
    private int id;
    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    @OneToMany(mappedBy = "disorder", cascade = CascadeType.ALL)
    private List<Symptom> symptoms;

    public Disorder(int id, String name, String description, List<Symptom> symptoms) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.symptoms = symptoms;
    }

    public Disorder() {

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Symptom> getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(List<Symptom> symptoms) {
        this.symptoms = symptoms;
    }

    /*
    @Override
    public String toString() {
        return "Disorder{" +
                "disorderId=" + disorderId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", symptoms=" + symptoms +
                '}';
    }
     */
}
