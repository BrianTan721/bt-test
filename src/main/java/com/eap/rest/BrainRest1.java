package com.eap.rest;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path("/")
public class BrainRest1 {

    @Inject
    ExeService es;

    @POST
    @Path("/json/{name}")
    @Produces("application/json")
    public String GetJSON(@PathParam("name") String name) {
        System.out.println("name:" + name);
        return "{\"result\":\"" + es.doMessage(name) + "\"}";

    }

    @POST
    @Path("/xml/{name}")
    @Produces("application/xml")
    public String GetXml(@PathParam("name") String name) {
        System.out.println("name:" + name);
        return "<xml><result>" + es.doMessage(name) + "</result></xml>";
    }

    @GET
    @Path("/ap")
    @Produces("application/json")
    public String exeGet() {
        try {
            System.out.println("Receive get request, sleep 5s...");
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "get method executed!";
    }

}
