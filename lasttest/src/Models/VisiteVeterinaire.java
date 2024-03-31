package Models;

import java.util.Date;

public class VisiteVeterinaire {

    private Date dateVisite;
    private String notes;

    public VisiteVeterinaire(Date dateVisite, String notes) {
        this.dateVisite = dateVisite;
        this.notes = notes;
    }
}
