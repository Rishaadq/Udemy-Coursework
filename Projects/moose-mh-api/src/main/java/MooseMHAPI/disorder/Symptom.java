package MooseMHAPI.disorder;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity(name="symptoms")
public class Symptom {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(nullable = false)
    private int id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private Disorder disorder;


    public Disorder getDisorder() {
        return disorder;
    }

    public void setDisorder(Disorder disorder) {
        this.disorder = disorder;
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

    /*
    @Override
    public String toString() {
        return "Symptom{" +
                "symptomId=" + symptomId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", disorder=" + disorder +
                '}';
    }

     */
}
