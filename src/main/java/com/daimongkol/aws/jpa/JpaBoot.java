package com.daimongkol.aws.jpa;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

public class JpaBoot {
    public static void main(String[] args) {

        // Create registry
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();

        // Create MetadataSources
        MetadataSources sources = new MetadataSources(registry);

        // Create Metadata
        Metadata metadata = sources.getMetadataBuilder().build();

        // Create SessionFactory
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();


        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();

            EmployeeEntity employeeEntity = new EmployeeEntity();
            employeeEntity.setFirstName("worasit");
            employeeEntity.setLastName("daimongkol");
            employeeEntity.setSalary(120000);

            session.save(employeeEntity);
            transaction.commit();

            Query from_employeeEntity = session.createQuery("from EmployeeEntity");

            for (Object result : from_employeeEntity.getResultList()) {
                System.out.println(result.toString());
            }

            session.clear();
            sessionFactory.close();
        }
    }
}
