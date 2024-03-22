package beans;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.User;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

@ManagedBean(name = "userRestBean", eager = true)
@SessionScoped
public class UserRestBean {
    private final String restResourceUrl = "http://localhost:8080/restTest_war/api/users";
    private final ObjectMapper mapper = new ObjectMapper();

    List<User> users;
    private HttpClient client;

    public UserRestBean() {
        client = HttpClient.newHttpClient();
    }

    public void getUsers() {
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI(restResourceUrl))
                    .GET()
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String result = response.body();
            users = mapper.readValue(result, new TypeReference<List<User>>(){});
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addUser(User user) {
        try {
            String json = mapper.writeValueAsString(user);
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI(restResourceUrl + "/add"))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(json))
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String result = response.body();
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<User> getUsersList() {
        return users;
    }




}

