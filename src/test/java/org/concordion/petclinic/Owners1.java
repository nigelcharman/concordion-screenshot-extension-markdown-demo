package org.concordion.petclinic;

import java.util.Collection;
import java.util.concurrent.atomic.AtomicInteger;

import org.chiknrice.test.SpringifiedConcordionRunner;
import org.concordion.api.SpecificationScoped;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.model.Owner;
import org.springframework.samples.petclinic.service.ClinicService;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(locations = {"classpath:spring/business-config.xml"})
@RunWith(SpringifiedConcordionRunner.class)
@ActiveProfiles("jdbc")
public class Owners1 {

    @Autowired
    protected ClinicService clinicService;

    @SpecificationScoped
    protected AtomicInteger atomicCount = new AtomicInteger(0);

    @SpecificationScoped
    protected Integer count = 0;

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
        if (count == null) {
            count = 0;
        }
        count++;
        if (atomicCount == null) {
            atomicCount = new AtomicInteger(0);
        }
        atomicCount.incrementAndGet();
    }

    public Collection<Owner> findOwnersByLastName(String lastName) {
        System.out.println(count);
        System.out.println(atomicCount);
        return this.clinicService.findOwnerByLastName(lastName);
    }
   
}
