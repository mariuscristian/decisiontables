package com.example.droolsdecisiontablesdemo;

import com.example.droolsdecisiontablesdemo.Customer.CustomerType;
import org.kie.api.KieServices;
import org.kie.api.builder.KieBuilder;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.builder.KieRepository;
import org.kie.api.builder.ReleaseId;
import org.kie.api.event.rule.AgendaEventListener;
import org.kie.api.io.Resource;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.internal.io.ResourceFactory;

public class DroolsConfig {
//  private static KieSession kieSession;

  public static KieSession config(String path) {
    KieServices kieServices = KieServices.get();
    Resource dt = ResourceFactory.newClassPathResource(path);
    KieFileSystem kieFileSystem = kieServices.newKieFileSystem().write(dt);
    KieBuilder kieBuilder = kieServices.newKieBuilder(kieFileSystem);
    kieBuilder.buildAll();
    KieRepository kieRepository = kieServices.getRepository();
//    ReleaseId krDefaultReleaseId = kieRepository.getDefaultReleaseId();
    ReleaseId krDefaultReleaseId = kieBuilder.getKieModule().getReleaseId();
    KieContainer kieContainer = kieServices.newKieContainer(krDefaultReleaseId);
    return kieContainer.newKieSession();
  }

  public static void main(String[] args) {
    KieSession kieSession = config("Discount.xls");
    Customer customer = new Customer(CustomerType.BUSINESS, 2);
    kieSession.insert(customer);

    AgendaEventListener agendaEventListener = new TrackingAgendaEventListener();
    kieSession.addEventListener(agendaEventListener);

    kieSession.fireAllRules();

    ((TrackingAgendaEventListener)agendaEventListener).matchsToString();
  }

}
