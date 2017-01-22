package org.concordion.petclinic;

import java.util.Collection;

import org.chiknrice.test.SpringifiedConcordionRunner;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.model.Owner;
import org.springframework.samples.petclinic.service.ClinicService;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;

import com.itextpdf.text.pdf.PdfStructTreeController.returnType;

@ContextConfiguration(locations = {"classpath:spring/business-config.xml"})
@RunWith(SpringifiedConcordionRunner.class)
@ActiveProfiles("jdbc")
public class Owners {

    @Autowired
    protected ClinicService clinicService;

    public Owner createEmptyOwner() {
        return new Owner();
    }

    public Owner createOwner(String firstName, String lastName, String address, String city, String phoneNumber) {
        Owner owner = new Owner();
        owner.setFirstName(firstName);
        owner.setLastName(lastName);
        owner.setAddress(address);
        owner.setCity(city);
        owner.setTelephone(phoneNumber);
        return owner; 
    }
    
    public Owner duplicate(Owner owner) {
        Owner dup = new Owner();
        dup.setFirstName(owner.getFirstName());
        dup.setLastName(owner.getLastName());
        dup.setAddress(owner.getAddress());
        dup.setCity(owner.getCity());
        dup.setTelephone(owner.getTelephone());
        return dup; 
    }
    
    public void saveOwner(Owner owner) {
        clinicService.saveOwner(owner);
    }

    public Collection<Owner> findOwnersByLastName(String lastName) {
        if ("<null>".equals(lastName)) {
            lastName = "";
        }
        return this.clinicService.findOwnerByLastName(lastName);
    }
}
