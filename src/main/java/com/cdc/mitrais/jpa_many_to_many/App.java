package com.cdc.mitrais.jpa_many_to_many;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.cdc.mitrais.jpa_many_to_many.entity.ClassRoom;
import com.cdc.mitrais.jpa_many_to_many.entity.Teacher;

public class App 
{
    public static void main( String[] args )
    {
        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("persistenceUnit");
        EntityManager entitymanager = emFactory.createEntityManager();
        
        entitymanager.getTransaction().begin();
        
        ClassRoom classRoomA = new ClassRoom(0, "Class 1.A", null);
        ClassRoom classRoomB = new ClassRoom(0, "Class 1.B", null);
        ClassRoom classRoomC = new ClassRoom(0, "Class 1.C", null);
        
        entitymanager.persist(classRoomA);
        entitymanager.persist(classRoomB);
        entitymanager.persist(classRoomC);
        
        Set<ClassRoom> classRoom1 = new HashSet<ClassRoom>();
        classRoom1.add(classRoomA);
        classRoom1.add(classRoomB);
        classRoom1.add(classRoomC);
        
        Set<ClassRoom> classRoom2 = new HashSet<ClassRoom>();
        classRoom2.add(classRoomB);
        classRoom2.add(classRoomA);
        classRoom2.add(classRoomC);
        
        Set<ClassRoom> classRoom3 = new HashSet<ClassRoom>();
        classRoom3.add(classRoomC);
        classRoom3.add(classRoomB);
        classRoom3.add(classRoomA);
        
        Teacher teacher1 = new Teacher(0, "Satish", "Java", classRoom1);
        Teacher teacher2 = new Teacher(0, "Krishna", "Adv Java", classRoom2);
        Teacher teacher3 = new Teacher(0, "Masthanvali", "DB2", classRoom3);
        
        entitymanager.persist(teacher1);
        entitymanager.persist(teacher2);
        entitymanager.persist(teacher3);
        
        entitymanager.getTransaction().commit();
        entitymanager.close();
        emFactory.close();
    }
}
