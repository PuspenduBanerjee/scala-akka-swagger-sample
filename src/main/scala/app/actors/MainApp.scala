package app.actors

import akka.actor.Props
import akka.camel.CamelExtension
import system.SpringContextActorSystemProvider

/**
  * Created by puspendu on 8/1/16.
  */
object SingleNodeApp extends App {
  // get hold of the actor system
  implicit val system = SpringContextActorSystemProvider.create()
val camel = CamelExtension(system)
  val camelCXFRest = system.actorOf(Props[CamelCXFRestInterface], name = "CamelCXFRestInterface")
  camel.context.addRoutes(new CustomRouteBuilder(system, camelCXFRest))
}
