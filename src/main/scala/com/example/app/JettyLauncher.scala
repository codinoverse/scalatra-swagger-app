package com.example.app

import org.eclipse.jetty.ee10.webapp.WebAppContext
import org.eclipse.jetty.server.Server
import org.scalatra.servlet.ScalatraListener

import java.awt.Window

object JettyLauncher extends App {

  val port = if (System.getenv("PORT") != null) then System.getenv("PORT").toInt else 8000

  val server = new Server(port)
  val context = new WebAppContext()
  context.setContextPath("/")
  context.setBaseResourceAsString("src/main/webapp")
  context.setInitParameter(ScalatraListener.LifeCycleKey, "com.example.app.ScalatraBootstrap")
  context.addEventListener(new ScalatraListener)
  //context.addServlet(classOf[HomeServlet], "/*")
  server.setHandler(context)
  server.start()
  server.join()



}
