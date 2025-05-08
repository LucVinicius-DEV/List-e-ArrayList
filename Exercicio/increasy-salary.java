import java.util.ArrayList; 
import java.util.List; 
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("How many employees will be registered? ");
        int n = sc.nextInt();

        List<Employee> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            System.out.println();
            System.out.println("Employee #" + (i + 1) + ":");
            System.out.print("Id: ");
            Integer id = sc.nextInt();
            while (hasId(list, id)) {
                System.out.print("Id already taken. Try again: ");
                id = sc.nextInt();
            }


            
            System.out.print("Name: ");
            sc.nextLine(); // limpa o buffer de leitura 
            String name = sc.nextLine();
            System.out.print("Salary: ");
            double salary = sc.nextDouble();   

            Employee emp = new Employee(id, name, salary);
            list.add(emp);
        }

        System.out.println();
        System.out.print("Enter the employee id that will have salary increase: ");
        int idsalary = sc.nextInt();

        Employee emp = list.stream().filter(x -> x.getId() == idsalary).findFirst().orElse(null);
        if (emp != null) {
            System.out.print("Enter the percentage: ");
            double percent = sc.nextDouble();
            emp.increaseSalary(percent);
        } else {
            System.out.println("This id does not exist!");
        }

        System.out.println();
        System.out.println("List of employees:");
        for (Employee obj : list) {
            System.out.println(obj);
        }

        sc.close();
    }
    public static boolean hasId(List<Employee> list, int id) {
        Employee emp = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
        return emp != null;
    }
    
}
