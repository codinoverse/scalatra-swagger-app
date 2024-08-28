package com.example.app.swagger

import org.scalatra.swagger.*

object EmployeeSwagger {
  val Info = ApiInfo(
    title = "Employee API",
    description = "Documentation for the Employee API",
    termsOfServiceUrl = "http://codinoverse.com",
    contact = ContactInfo(name = "Team Codino", url = "http://codionverse.com", email = "vishals.singh@codionverse.com"),
    license = LicenseInfo(name = "MIT", url = "http://codionoverse.com")
  )
}

class EmployeeSwagger extends Swagger(Swagger.SpecVersion, "1.0", EmployeeSwagger.Info)