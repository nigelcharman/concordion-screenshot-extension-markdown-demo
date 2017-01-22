package org.concordion.petclinic;

import java.util.Collection;

import org.chiknrice.test.SpringifiedConcordionRunner;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.model.Owner;
import org.springframework.samples.petclinic.service.ClinicService;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(locations = {"classpath:spring/business-config.xml"})
@RunWith(SpringifiedConcordionRunner.class)
@ActiveProfiles("jdbc")
public class Pets {

    @Autowired
    protected ClinicService clinicService;

    public Collection<Owner> findOwnersByLastName(String lastName) {
        return this.clinicService.findOwnerByLastName(lastName);
    }
}
