package om.gov.taxoman;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import om.gov.taxoman.entity.Customer;
import om.gov.taxoman.entity.Property;
import om.gov.taxoman.entity.PropertyOwner;
import om.gov.taxoman.entity.Rental;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import static jakarta.persistence.Persistence.createEntityManagerFactory;
import static java.time.LocalDate.parse;

public class Main {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Salim.jpa");

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();


Customer customer= new Customer();
customer.setFullName("Salim");
customer.setEmail("salim.gmail.com");
customer.setPassword("111");
//2
em.persist(customer);

        Customer customer1= new Customer();
        customer1.setFullName("Salim");
        customer1.setEmail("salim.gmail.com");
        customer1.setPassword("111");
        //2
        em.persist(customer1);

        Customer customer2= new Customer();
        customer2.setFullName("Salim");
        customer2.setEmail("salim.gmail.com");
        customer2.setPassword("111");
        em.persist(customer2);

        Customer customer3= new Customer();
        customer3.setFullName("Salim");
        customer3.setEmail("salim.gmail.com");
        customer3.setPassword("111");
        em.persist(customer3);

        PropertyOwner propertyOwner = new PropertyOwner();
        propertyOwner.setPassword("111");
        propertyOwner.setEmail("sos@hotmail.com");
        propertyOwner.setPhoneNumber("9898999");
        //3
        em.persist(propertyOwner);

        PropertyOwner propertyOwner1 = new PropertyOwner();
        propertyOwner1.setPassword("222");
        propertyOwner1.setEmail("mmm@hotmail.com");
        propertyOwner1.setPhoneNumber("8578888");
        em.persist(propertyOwner1);

        PropertyOwner propertyOwner2 = new PropertyOwner();
        propertyOwner2.setPassword("78");
        propertyOwner2.setEmail("n1@hotmail.com");
        propertyOwner2.setPhoneNumber("98747777");
        em.persist(propertyOwner2);

        PropertyOwner propertyOwner3 = new PropertyOwner();
        propertyOwner3.setPassword("7999");
        propertyOwner3.setEmail("ujh@hotmail.com");
        propertyOwner3.setPhoneNumber("98587777");
        em.persist(propertyOwner3);


        // first we have to find owner by this code
        PropertyOwner foundPropertyOwner1 = em.find(PropertyOwner.class, 1);
        PropertyOwner foundPropertyOwner2 = em.find(PropertyOwner.class, 2);
        PropertyOwner foundPropertyOwner3 = em.find(PropertyOwner.class, 3);


        Property property = new Property();
    property.setDayRentalPrice(50);
    property.setName("villa 1");
    property.setPropertyOwner(foundPropertyOwner1);
    em.persist(property);


        Property property1 = new Property();
        property1.setDayRentalPrice(60);
        property1.setName("villa 2");
        //4
        property1.setPropertyOwner(foundPropertyOwner1);
        em.persist(property1);

        Property property3 = new Property();
        property3.setDayRentalPrice(70);
        property3.setName("villa 3");
        property3.setPropertyOwner(foundPropertyOwner2);
        em.persist(property3);


        Property property4 = new Property();
        property4.setDayRentalPrice(70);
        property4.setName("villa 4");
        property4.setPropertyOwner(foundPropertyOwner3);
        em.persist(property4);


        //5
        Customer foundCustomer = em.find(Customer.class, 1);
        Property foundProperty = em.find(Property.class, 1);

        Rental rental= new Rental();
        rental.setStartDate(LocalDate.of(1999,4,24));
        rental.setEndDate(LocalDate.of(2004,6,1));
        rental.setRentingAmount(50);
        //6
        rental.setCustomer(foundCustomer);
        rental.setProperty(foundProperty);
        em.persist(rental);










        em.getTransaction().commit();
        em.close();
        emf.close();




    }
}