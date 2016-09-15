package app.actors

import akka.actor.{Actor, ActorRef, ActorSystem}
import akka.camel.{CamelMessage,_}
import app.rest.model.DummyResponse
import org.apache.camel.builder.RouteBuilder

class CamelCXFRestInterface extends Actor {

  def receive =  {
    case msg: CamelMessage =>
      val whoamI= Option(msg.headers("whoami")).getOrElse("Anonymous").toString
      sender() ! new DummyResponse(whoamI.hashCode,whoamI)
  }
}

class CustomRouteBuilder(system: ActorSystem, responder: ActorRef)
  extends RouteBuilder {
  def configure {
    from("cxfrs:bean:rsServer?bindingStyle=SimpleConsumer")
      .routeId("cxf-rest-route")
      .to(responder)

  }
}
