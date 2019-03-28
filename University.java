package src;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Clase principal
 * Se puede
 */
public class University {
    public static final EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("University");
    public static final EntityManager entitymanager = emfactory.createEntityManager();
    public static void main( String[ ] args ) throws IOException {
        //6
        String cadenaArchivo = "";
        BufferedWriter writer = new BufferedWriter(new FileWriter("student.txt"));

        Query query1 = entitymanager.createQuery("select se from StudentEntity se ");
        List<StudentEntity> listase = query1.getResultList();
        for (StudentEntity se: listase){
            System.out.println(se.toString());
            cadenaArchivo = cadenaArchivo + se.toString();
        }
        writer.write(cadenaArchivo);
        writer.close();
        System.out.println("\n \n");

        cadenaArchivo = "";
        writer = new BufferedWriter(new FileWriter("department.txt"));
        query1 = entitymanager.createQuery("select de from DepartmentEntity de");
        List<DepartmentEntity> listade = query1.getResultList();
        for (DepartmentEntity de: listade){
            System.out.println(de.toString());
            cadenaArchivo = cadenaArchivo + de.toString();
        }
        writer.write(cadenaArchivo);
        writer.close();
        System.out.println("\n \n");

        cadenaArchivo = "";
        writer = new BufferedWriter(new FileWriter("instructor.txt"));

        //2
        query1 = entitymanager.createQuery("select ie from InstructorEntity ie");
        List<InstructorEntity> listaie = query1.getResultList();
        for (InstructorEntity ie: listaie){
            System.out.println(ie.toString());
            cadenaArchivo = cadenaArchivo + ie.toString();
        }

        writer.write(cadenaArchivo);
        writer.close();
        System.out.println("\n \n");

        //3
        System.out.println("Department with biggest budget: "+ maxSalario());
        System.out.println("\n \n");

        //4
        Query query2 = entitymanager.createQuery("select ae from AdvisorEntity ae");
        List<AdvisorEntity> listaae = query2.getResultList();
        Map<String,String> asesorias = new HashMap<>();
        for (AdvisorEntity ae: listaae){
            String nombreT = "";
            query2 = entitymanager.createQuery("select ie.name from InstructorEntity ie where ie.id =" + ae.getiId());
            asesorias.put(ae.getsId(),(String) query2.getSingleResult());
        }
        System.out.println(asesorias.toString());
        System.out.println("\n \n");

        //5
        Query query3 = entitymanager.createQuery("select ie from InstructorEntity ie");
        List<InstructorEntity> listaie2 = query3.getResultList();
        Map<String,List<StudentEntity>> asesorado = new HashMap<>();
        for (InstructorEntity ie: listaie2){
            String nombreT = "";
            query3 = entitymanager.createQuery("select se from StudentEntity se where se.id in (select ae.sId from AdvisorEntity ae where ae.iId =" + ie.getId() + ")");
            asesorado.put(ie.getName(),query3.getResultList());
        }
        System.out.println(asesorado.toString());
        System.out.println("\n \n");

    }
    // 3
    public static BigDecimal maxSalario() {
        Query query3 = entitymanager.createQuery("Select MAX(e.budget) from DepartmentEntity e");
        BigDecimal result = (BigDecimal) query3.getSingleResult();
        return result;
    }

}
