package operator_overloading

fun main(args:Array<String>){
    // your company
    val company = Company("MyOwnCompany")
    // departments
    val developmentDepartment = Department("Development")
    val qaDepartment = Department("Quality Assurance")
    val hrDepartment = Department("Human Resources")
    // employees
    var Julia = Employee(company, "Julia", 100_000)
    var John = Employee(company, "John", 86_000)
    var Peter = Employee(company, "Peter", 100_000)
    var Sandra = Employee(company, "Sandra", 75_000)
    var Thomas = Employee(company, "Thomas", 73_000)
    var Alice = Employee(company, "Alice", 70_000)
    var Bernadette = Employee(company, "Bernadette", 66_000)
    var Mark = Employee(company, "Mark", 66_000)

    //теперь операторы можно использовать вот так
    Mark += 2500
    Alice -= 2000

    //аналогичные операции
//    Mark.plusAssign(2500);
//    Alice.minusAssign(2000);

    company += developmentDepartment
    company += qaDepartment
    company += hrDepartment
    developmentDepartment += Julia
    developmentDepartment += John
    developmentDepartment += Peter
    qaDepartment += Sandra
    qaDepartment += Thomas
    qaDepartment += Alice
    hrDepartment += Bernadette
    hrDepartment += Mark
    qaDepartment -= Thomas

    //Если работники имеются, то вернется первый иначе null
    val firstEmployee = qaDepartment[0]

    if (Thomas !in qaDepartment) {
        println("${Thomas.name} no longer works here")
    }

    //переопределили компаратор и теперь можно пробегаясь по классу - пробегаться по коллекции
    developmentDepartment.forEach {
        // do something
    }

}

class Company(val name: String) {
    private val departments: ArrayList<Department> = arrayListOf()

    operator fun plusAssign(department: Department) {
        departments.add(department)
    }

    operator fun minusAssign(department: Department){
        departments.remove(department)
    }
}

class Department(val name: String) :Iterable<Employee>{
    val employees: ArrayList<Employee> = arrayListOf()

    operator fun plusAssign(employee: Employee) {
        employees.add(employee)
        println("${employee.name} hired to $name department")
    }
    operator fun minusAssign(employee: Employee) {
        if (employees.contains(employee)) {
            employees.remove(employee)
            println("${employee.name} fired from $name department")
        }
    }

    operator fun get(index: Int): Employee? {
        return if (index < employees.size) {
            employees[index]
        } else {
            null
        }
    }

    operator fun set(index: Int, employee: Employee) {
        if (index < employees.size) {
            employees[index] = employee
        }
    }

    operator fun contains(employee: Employee) =
            employees.contains(employee)

    override fun iterator(): Iterator<Employee> = employees.iterator()
}

class Employee(val company: Company, val name: String, var salary: Int):Comparable<Employee>{
    operator fun plusAssign(increaseSalary: Int) {
        salary += increaseSalary
        println("$name got a raise to $$salary")
    }
    operator fun minusAssign(decreaseSalary: Int) {
        salary -= decreaseSalary
        println("$name's salary decreased to $$salary")
    }

    override fun compareTo(other: Employee): Int {
        return when(other){
            this->0
            else->name.compareTo(other.name)
        }
    }
}


