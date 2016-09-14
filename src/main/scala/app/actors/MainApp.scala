package app.actors

import java.util.Properties

import akka.actor.Props
import akka.camel.CamelExtension
import com.typesafe.config.ConfigFactory
import system.SpringContextActorSystemProvider

/**
  * Created by puspendu on 8/1/16.
  */
object MainApp extends App {
  // get hold of the actor system
  val properties=new Properties()
  properties.setProperty("rest.port","18877")
  implicit val system = SpringContextActorSystemProvider.create("SpringActorSystem",ConfigFactory.load(),properties)
val camel = CamelExtension(system)
  val camelCXFRest = system.actorOf(Props[CamelCXFRestInterface], name = "CamelCXFRestInterface")
  camel.context.addRoutes(new CustomRouteBuilder(system, camelCXFRest))
}
