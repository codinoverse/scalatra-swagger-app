package controller

import com.example.app.dao.EmployeeDao
import com.example.app.model.Employee
import org.json4s.{DefaultFormats, Formats, jvalue2extractable}
import org.scalatra.*
import org.scalatra.json.*
import org.scalatra.swagger.*

class EmployeeServlet(implicit val swagger: Swagger) extends ScalatraServlet with NativeJsonSupport with SwaggerSupport {

  protected implicit val jsonFormats: DefaultFormats.type = DefaultFormats

  protected def applicationDescription: String = "The Employees API"

  before() {
    contentType = formats("json")
  }

  // Existing getEmployee operation
  val getAllEmployees =
    apiOperation[List[Employee]]("getEmployees")
      .summary("Show All Employees")
      .tags("Employees")
      .description("Show All the employee names")


  get("/", operation(getAllEmployees)) {
    EmployeeDao.all.values.toList
  }

  val getEmployeeById =
    apiOperation[Option[Employee]]("getEmployeeById")
      .summary("Gets Employee By id")
      .tags("Employee")
      .description("Show Employee with id")
      .parameter(queryParam[Option[String]]("id"))
      .description("An id to be Searched for")


  get("/:id",operation(getEmployeeById)){
    params.get("id") match
      case Some(value) => EmployeeDao.all.get(value)
      case None => halt(404,"Employee Not Found")
  }


  val createEmployee =
    apiOperation[Employee]("createemployee")
      .summary("Create a new Employee")
      .tags("Employee")
      .description("Create a new Employee")
      .parameter(bodyParam[Employee]("employee").description("The Employee object to be created").required)



  post("/",operation(createEmployee)){
    val employee = parsedBody.extract[Employee]
    EmployeeDao.all+=(employee.id->employee)
    employee


  }

  val updatedEmployee =
    apiOperation[Employee]("updateEmployee")
      .summary("Update an existing employee")
      .tags("Employees")
      .description("Update an existing employee. The request body should contain the updated employee details in JSON format.")
      .parameter(bodyParam[Employee]("employee"))
      .parameter(queryParam[Option[String]]("id"))
      .description("The ID of the employee to update")




  put("/:id",operation(updatedEmployee)){
    params.get("id") match
      case Some(value) => EmployeeDao.all.get(value) match
        case Some(value) => {
          val employee = parsedBody.extract[Employee]
          EmployeeDao.all+=(employee.id->employee)
          employee

        }
        case None => halt(404,"Employee Not Found")
      case None => halt(404,"Employee Not Found")
  }



}