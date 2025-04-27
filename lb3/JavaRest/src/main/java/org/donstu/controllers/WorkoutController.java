package org.donstu.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.Response;
import org.donstu.domain.Workout;

@Path("/workout")
public class WorkoutController {
    private static List<Workout> workouts = new ArrayList();

    public WorkoutController() {
    }

    @GET
    @Path("/")
    @Produces({"application/json"})
    public Response defaultPath() {
        return this.getWorkouts();
    }

    @GET
    @Path("/list")
    @Produces({"application/json"})
    public Response getWorkouts() {
        GenericEntity<List<Workout>> genericEntity = new GenericEntity<List<Workout>>(workouts) {};
        return Response.ok(genericEntity).build();
    }

    @GET
    @Path("/{id}")
    @Produces({"application/json"})
    public Response getWorkout(@PathParam("id") String id) {
        int num = Integer.parseInt(id);
        return workouts.size() <= num ?
                Response.status(Response.Status.NOT_FOUND).build() :
                Response.ok(workouts.get(num)).build();
    }

    static {
        workouts.add(new Workout("Йога", new Date(), 60, "Анна Вербер"));
        workouts.add(new Workout("Фитнес", new Date(), 45, "Иван Сидоров"));
        workouts.add(new Workout("Пилатес", new Date(), 55, "Мария Иванова"));
    }
}