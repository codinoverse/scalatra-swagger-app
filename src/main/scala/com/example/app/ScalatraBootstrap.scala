package com.example.app

import com.example.app.swagger.{EmployeeSwagger, ResourcesApp}
import controller.EmployeeServlet
import jakarta.servlet.ServletContext
import org.scalatra.LifeCycle
import org.scalatra.swagger.Swagger

class ScalatraBootstrap extends LifeCycle {
  implicit val swagger: Swagger = new EmployeeSwagger

  override def init(context: ServletContext): Unit = {
    context.mount(new EmployeeServlet, "/employees", "employees")
    context.mount(new ResourcesApp, "/api-docs")
  }
}