package com.example.app.swagger

import org.scalatra.ScalatraServlet
import org.scalatra.swagger.*

class ResourcesApp(implicit val swagger: Swagger) extends ScalatraServlet with NativeSwaggerBase