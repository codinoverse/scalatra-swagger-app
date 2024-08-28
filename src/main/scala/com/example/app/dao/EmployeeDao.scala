package com.example.app.dao

import com.example.app.model.Employee

import scala.collection.mutable.Map

object EmployeeDao {
  
  val all = Map[String,Employee](
    ("1001",Employee("1001","balaji","backend developer")),
    ("1002",Employee("1002","raviTeja.c","Full stack")),
    ("1003",Employee("1003","vishal","Backend")),
    ("1004",Employee("1004","RaviTeja.B","FrontEnd Developer")),
    ("1005",Employee("1005","Nivedh","Devops Enginerr"))
  )

}
