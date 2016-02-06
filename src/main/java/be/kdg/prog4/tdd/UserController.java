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
public class UserController {
    @Autowired
    private FavoriteService favoriteService;

    @RequestMapping(value = "/addFavorite.do", method = RequestMethod.POST)
    public String addFavorite(@RequestParam String favorite, HttpSession session, Model model) {
        String username = (String) session.getAttribute("username");
        String password = (String) session.getAttribute("password");
        favoriteService.addFavorite(username, password, favorite);
        List<String> favorites = favoriteService.getFavorites(username, password);
        model.addAttribute("favorites", favorites);
        return "user";
    }
}
