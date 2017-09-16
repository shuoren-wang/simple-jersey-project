package resource;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import finder.UserFinder;
import model.User;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("user")
public class UserResource {
    private static final ObjectMapper mapper = new ObjectMapper();

    @GET
    @Path("{user_id}/info")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUserInfo(
            @PathParam("user_id") Integer id) throws JsonProcessingException {
        UserFinder finder = new UserFinder();
        User user = finder.getUser(id);

        if (user == null) {
            return Response.noContent().build();
        } else {
            String json = mapper.writeValueAsString(finder.getUser(id));
            return Response.ok(json).build();
        }
    }
}
