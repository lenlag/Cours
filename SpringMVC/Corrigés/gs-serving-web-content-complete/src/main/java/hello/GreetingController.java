package hello;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController {

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="nom", required=false, defaultValue="World") String name,
    		@RequestParam(name="age", required=false, defaultValue="0") String age,
    		Model model,HttpServletRequest request) {
        model.addAttribute("machin", name);
        model.addAttribute("age",age);
        List<CartItem> list = new ArrayList<>();
        list.add(new CartItem("AAA","CodeA",10,2));
        list.add(new CartItem("BBB","CodeB",20,5));
        Cart m = new Cart();
        m.setList(list);
        request.getSession().setAttribute("panier", m);
        model.addAttribute("liste",request.getSession().getAttribute("panier"));
        return "greeting";
    }
    @GetMapping("/zoom")
    public String zoom(@RequestParam(name="salut",required=false, defaultValue="Salut") String hello,
    		Model model,HttpServletRequest request) {
        model.addAttribute("hello", hello);
        model.addAttribute("liste",request.getSession().getAttribute("panier"));
        return "zoom";
    }
    @PostMapping("/greeting/listobject")
    public String listure(Cart m,Model model,HttpServletRequest request) {
        request.getSession().setAttribute("panier", m);
        model.addAttribute("liste",m);
        return "greeting";
    }
    @PostMapping("/greeting/listarray")
    public String listure(@RequestParam(name="nb") int[] nbs,Model model,HttpServletRequest request) {
        Cart panier = (Cart)request.getSession().getAttribute("panier");
        int i = 0;
        for (CartItem truc:panier.getList()) {
        	truc.setQuant(nbs[i]);
        	i++;
        }
        model.addAttribute("liste",panier);
        return "greeting";
    }

}
