package be.kdg.prog4.tdd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class LoginController {
    @Autowired
    private FavoriteService favoriteService;

    @RequestMapping(value = "/login.do", method = RequestMethod.POST)
    public String login(@RequestParam String username, @RequestParam String password, Model model, HttpSession session) {
        System.out.println("controller: login()");
        if (!favoriteService.checkLogin(username, password)) {
            model.addAttribute("error", "Wrong username or password");
            System.out.println("returning index");
            return "index";
        }
        if (favoriteService.isRoot(username, password)) {
            System.out.println("returning root");
            return "root";
        }
        System.out.println("returning user");
        session.setAttribute("username", username);
        session.setAttribute("password", password);
        List<String> favorites = favoriteService.getFavorites(username, password);
        model.addAttribute("favorites", favorites);
        return "user";
    }
}
