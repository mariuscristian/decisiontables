package com.example.droolsdecisiontablesdemo;

import static org.junit.Assert.assertEquals;

import com.example.droolsdecisiontablesdemo.Customer.CustomerType;
import org.junit.Before;
import org.junit.Test;
import org.kie.api.runtime.KieSession;

public class DiscountExcelIntegrationTest {

  private KieSession kSession;

  @Before
  public void setup() {
//    Resource dt
//        = ResourceFactory
//        .newClassPathResource("Discount.xls",
//            getClass());
//    kSession = new DroolsBeanFactory().getKieSession(dt);
    kSession = DroolsConfig.config("Discount.xls");
  }

  @Test
  public void
  giveIndvidualLongStanding_whenFireRule_thenCorrectDiscount()
      throws Exception {
    Customer customer = new Customer(CustomerType.INDIVIDUAL, 5);
    kSession.insert(customer);

    kSession.fireAllRules();

    assertEquals(customer.getDiscount(), 15);
  }

  @Test
  public void
  giveIndvidualRecent_whenFireRule_thenCorrectDiscount()
      throws Exception {
    Customer customer = new Customer(CustomerType.INDIVIDUAL, 1);
    kSession.insert(customer);

    kSession.fireAllRules();

    assertEquals(customer.getDiscount(), 5);
  }

  @Test
  public void
  giveBusinessAny_whenFireRule_thenCorrectDiscount()
      throws Exception {
    Customer customer = new Customer(CustomerType.BUSINESS, 0);
    kSession.insert(customer);

    kSession.fireAllRules();

    assertEquals(customer.getDiscount(), 20);
  }
}